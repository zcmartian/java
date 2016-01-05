import java.io.*;
import java.util.*;

public class Main {

    private static final String DIANPINGCSV = "/Users/marszhou/Downloads/dianping.csv";
    private static final String MEITUANCSV = "/Users/marszhou/Downloads/meituan2.csv";
    private static final String DIFFCSV = "/Users/marszhou/Downloads/diff.csv";
    private static HashMap<Long, ArrayList<BankInfo>> dianpingMap = new HashMap<Long, ArrayList<BankInfo>>();
    private static HashMap<Long, ArrayList<BankInfo>> meituanMap = new HashMap<Long, ArrayList<BankInfo>>();
    private static HashSet<Diff> diffList;
    private static int count;
    public static void main(String[] args) {
        if (readFile(DIANPINGCSV, dianpingMap)) {
            System.out.println("dianping map load success!");
        } else {
            return;
        }
        if (readFile(MEITUANCSV, meituanMap)) {
            System.out.println("meituan map load success!");
        } else {
            return;
        }

        dedupAnalyze();
        outputResult();
    }

    public static boolean readFile(String fileName, HashMap<Long, ArrayList<BankInfo>> list) {
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            BankInfo bankInfo = null;
            count = 0;
            tempString = reader.readLine();
            if (tempString != null) {
                while((tempString = reader.readLine()) != null) {
                    bankInfo = parseToBankInfo(tempString);
                    Long poiid = bankInfo.getPoi_id();
                    ArrayList<BankInfo> bankList = list.get(poiid);
                    if (bankList == null) {
                        bankList = new ArrayList<BankInfo>();
                        list.put(poiid, bankList);
                    }
                    bankList.add(bankInfo);
                    ++count;
                }
            }
            reader.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(count);
            return false;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println(count);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(count);
                    return false;
                }
            }
        }
    }

    private static BankInfo parseToBankInfo(String str) {
        String[] arrayStr = str.split("\t");
        if (arrayStr.length == 19) {
            BankInfo bankInfo = new BankInfo();
            bankInfo.setPoi_id(Long.parseLong(arrayStr[0]));
            bankInfo.setAccountName(arrayStr[7]);
            bankInfo.setCardNumber(arrayStr[10]);
            return bankInfo;
        } else if (arrayStr.length == 2){
            BankInfo bankInfo = new BankInfo();
            bankInfo.setPoi_id(Long.parseLong(arrayStr[0]));
            bankInfo.setOuterId(Long.parseLong(arrayStr[1]));
            return bankInfo;
        } else {
            return null;
        }
    }
     private static void dedupAnalyze() {
         diffList = new HashSet<Diff>();
         Iterator iter = dianpingMap.entrySet().iterator();
         while (iter.hasNext()) {
             Map.Entry<Long, ArrayList<BankInfo>> entry =
                     (Map.Entry<Long, ArrayList<BankInfo>>) iter.next();
             Long poiid = entry.getKey();
             ArrayList<BankInfo> bankListDianping = entry.getValue();
             ArrayList<BankInfo> bankInfoMeituan = meituanMap.get(poiid);
             if (bankInfoMeituan != null && !bankInfoMeituan.isEmpty()) {
                 for (int i = 0; i < bankListDianping.size(); ++i) {
                     for (int j = 0; j < bankInfoMeituan.size(); ++j) {
                         if (bankListDianping.get(i)
                                 .equals(bankInfoMeituan.get(j))) {
                             continue;
                         } else {
                             diffList.add(new Diff(poiid,
                                     bankListDianping.get(i).getCardNumber(),
                                     bankInfoMeituan.get(j).getCardNumber()));
                         }
                     }
                 }
             }
         }
     }

    public static void outputResult() {
        try {
            FileWriter fileWriter = new FileWriter(DIFFCSV);
            for (Diff diffBankInfo : diffList) {
                fileWriter.write(diffBankInfo.toString());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
