import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main2 {

    public static final String DIANPINGCSV = "/Users/marszhou/Downloads/dianping2.csv";
    public static final String DIANPINGMEITUANCSV = "/Users/marszhou/Downloads/meituanmapp.csv";
    public static final String MEITUANCSVFOLDER = "/Users/marszhou/Downloads/";
    public static final String DIFFCSVPREFIX = "/Users/marszhou/Downloads/diff";
    public static final String OUTPUTCSV = "/Users/marszhou/Downloads/output.csv";
    public static final String MODIFIEDOUTPUTCSV = "/Users/marszhou/Downloads/result.csv";
    public static final String MODIFIEDPRECISEOUTPUTCSV = "/Users/marszhou/Downloads/precise.csv";
    public static final String SHOPIDCSV = "/Users/marszhou/Downloads/shopids.csv";
    public static final int THREAD_NUMBER = 13;
    public static HashMap<Long, ArrayList<BankInfo>> dianpingMap = new HashMap<>();
    public static HashMap<Long, ArrayList<BankInfo>> dianpingMeituanMap = new HashMap<>();
    public static ConcurrentHashMap<Long, ArrayList<BankInfo>> originalMeiTuanMap = new ConcurrentHashMap<>();
    public static HashMap<Long, ArrayList<BankInfo>> updatedMeiTuanMap;
    public static HashMap<Long, ArrayList<Diff>> modifiedOutputMap = new HashMap<>();
    public static HashSet<Diff> diffSet;
    public static int count;
    public static int diffSetCount = 0;
    public static int originalMeiTuanMapCount = 0;
    public static int updatedMeiTuanMapCount = 0;

    public static void main(String[] args) throws InterruptedException {
        if (args.length == 1) {
            switch (Integer.parseInt(args[0])) {
                case 1:
                    analyze();
                    break;
                case 2:
                    merge();
                    break;
                case 3:
//                output();
                    outputShopIds();
                    break;
            }
        }
    }

    private static void output() {
        readOutputFile(OUTPUTCSV, modifiedOutputMap);
        System.out.println("total modifiedOutputMap size is: "
                + modifiedOutputMap.size());
        outputResult();
    }

    private static void merge() {
        try {
            FileWriter fileWriter = new FileWriter(OUTPUTCSV);
            StringBuilder head = new StringBuilder();
            head.append("DPPOI\t");
            head.append("DPShopID\t");
            head.append("MTShopID\t");
            head.append("DPActNum\t");
            head.append("MTActNum\t");
            head.append("DPBankActName\t");
            head.append("MTBankActName\n");
            fileWriter.write(head.toString());
            fileWriter.flush();
            for (int i = 1; i <= 13; ++i) {
                File file = new File(DIFFCSVPREFIX + i + ".csv");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String tempString;
                while ((tempString = reader.readLine()) != null) {
                    fileWriter.write(tempString);
                    fileWriter.write("\n");
                }
                fileWriter.flush();
                reader.close();
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void analyze() throws InterruptedException {
        if (readFile(DIANPINGCSV, dianpingMap)) {
            System.out.println("dianping map load success!");
            System.out.println("dianping map size is: " + dianpingMap.size());
        } else {
            return;
        }

        if (readFile(DIANPINGMEITUANCSV, dianpingMeituanMap)) {
            System.out.println("dianpingMeituan map load success!");
            System.out.println("dianpingMeituan map size is: "
                    + dianpingMeituanMap.size());
        } else {
            return;
        }

        for (int i = 1; i <= THREAD_NUMBER; ++i) {
            Thread thread = new ReadFileThread();
            thread.setName(String.valueOf(i));
            thread.start();
            thread.join();

            System.out.println("current originalMeiTuanMap size is: "
                    + Main2.originalMeiTuanMap.size());
            originalMeiTuanMapCount += originalMeiTuanMap.size();

            updateMeituanMap();
            dedupAnalyze();
            outputResult(i);

            originalMeiTuanMap.clear();
            updatedMeiTuanMap.clear();
            diffSet.clear();
        }

        System.out.println("total originalMeiTuanMap size is: "
                + originalMeiTuanMapCount);
        System.out.println("total updatedMeiTuanMap size is: "
                + updatedMeiTuanMapCount);
        System.out.println("total diffSet size is: " + diffSetCount);
    }

    public static boolean readOutputFile(String fileName,
                                         HashMap<Long, ArrayList<Diff>> list) {
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            Diff diffInfo;
            count = 0;
            tempString = reader.readLine();
            if (tempString != null)
                while ((tempString = reader.readLine()) != null) {
                    diffInfo = parseToDiff(tempString);
                    if (diffInfo != null) {
                        Long poiId = diffInfo.getPoiId();
                        ArrayList<Diff> bankList = list.get(poiId);
                        if (bankList == null) {
                            bankList = new ArrayList<>();
                            list.put(poiId, bankList);
                        }
                        bankList.add(diffInfo);
                    }
                }
            reader.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
    }

    public static boolean readFile(String fileName,
                                   HashMap<Long, ArrayList<BankInfo>> list) {
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            BankInfo bankInfo;
            count = 0;
            tempString = reader.readLine();
            if (tempString != null) {
                while ((tempString = reader.readLine()) != null) {
                    bankInfo = parseToBankInfo(tempString);
                    if (bankInfo != null) {
                        Long poiId = bankInfo.getPoi_id();
                        ArrayList<BankInfo> bankList = list.get(poiId);
                        if (bankList == null) {
                            bankList = new ArrayList<>();
                            list.put(poiId, bankList);
                        }
                        bankList.add(bankInfo);
                    }
                }
            }
            reader.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
    }

    public static Diff parseToDiff(String str) {
        String[] arrayStr = str.split("\t");
        if (arrayStr.length == 7) {
            Diff diff = new Diff(Long.parseLong(arrayStr[0]),
                    Long.parseLong(arrayStr[1]), Long.parseLong(arrayStr[2]),
                    arrayStr[3], arrayStr[4], arrayStr[5], arrayStr[6]);
            return diff;
        } else {
            return null;
        }
    }

    public static BankInfo parseToBankInfo(String str) {
        String[] arrayStr = str.split("\t");
        if (arrayStr.length == 19) {
            BankInfo bankInfo = new BankInfo();
            bankInfo.setPoi_id(Long.parseLong(arrayStr[0]));
            bankInfo.setOuterId(Long.parseLong(arrayStr[1]));
            bankInfo.setBankAccountName(arrayStr[7]);
            bankInfo.setCardNumber(arrayStr[10]);
            return bankInfo;
        } else if (arrayStr.length == 2) {
            BankInfo bankInfo = new BankInfo();
            bankInfo.setPoi_id(Long.parseLong(arrayStr[0]));
            bankInfo.setOuterId(Long.parseLong(arrayStr[1]));
            return bankInfo;
        } else if (arrayStr.length == 9) {
            BankInfo bankInfo = new BankInfo();
            bankInfo.setOuterId(Long.parseLong(arrayStr[0]));
            bankInfo.setPoi_id(Long.parseLong(arrayStr[0]));
            bankInfo.setBankName(arrayStr[1]);
            bankInfo.setBankAccountName(arrayStr[2]);
            bankInfo.setBankBranch(arrayStr[4]);
            bankInfo.setCardNumber(arrayStr[5]);
            return bankInfo;
        } else {
            return null;
        }
    }

    public static void dedupAnalyze() {
        diffSet = new HashSet<Diff>();
        Iterator iter = dianpingMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Long, ArrayList<BankInfo>> entry = (Map.Entry<Long, ArrayList<BankInfo>>) iter
                    .next();
            Long poiid = entry.getKey();
            ArrayList<BankInfo> bankListDianping = entry.getValue();
            ArrayList<BankInfo> bankInfoMeituan = updatedMeiTuanMap.get(poiid);
            if (bankListDianping != null && bankInfoMeituan != null
                    && !bankListDianping.isEmpty()
                    && !bankInfoMeituan.isEmpty()) {
                for (int i = 0; i < bankListDianping.size(); ++i) {
                    boolean isEqual = false;
                    if (!isEqual) {
                        for (int j = 0; j < bankInfoMeituan.size(); ++j) {
                            try {
                                if (bankListDianping.get(i).equals(
                                        bankInfoMeituan.get(j))) {
                                    isEqual = true;
                                    break;
                                } else {
                                    continue;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (!isEqual) {
                            for (int j = 0; j < bankInfoMeituan.size(); ++j) {
                                diffSet.add(new Diff(poiid, bankListDianping
                                        .get(i).getOuterId(), bankInfoMeituan
                                        .get(j).getOuterId(), bankListDianping
                                        .get(i).getCardNumber(),
                                        bankInfoMeituan.get(j).getCardNumber(),
                                        bankListDianping.get(i)
                                                .getBankAccountName(),
                                        bankInfoMeituan.get(j)
                                                .getBankAccountName()));
                            }
                        }
                    }
                }
            }
        }
        System.out.println("current diff list size is: " + diffSet.size());
        diffSetCount += diffSet.size();
    }

    public static void outputResult(int i) {
        try {
            FileWriter fileWriter = new FileWriter(DIFFCSVPREFIX + i + ".csv");

//            fileWriter.write(head.toString());
            for (Diff diffBankInfo : diffSet) {
                fileWriter.write(diffBankInfo.toString());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputShopIds() {
        readOutputFile(OUTPUTCSV, modifiedOutputMap);
        System.out.println("total modifiedOutputMap size is: "
                + modifiedOutputMap.size());
        int total = 0;
        try {
            FileWriter fileWriter = new FileWriter(SHOPIDCSV);
            StringBuilder head = new StringBuilder();
            head.append("DPShopID\t");
            head.append("MTShopID\n");
            fileWriter.write(head.toString());
            Iterator iterator = modifiedOutputMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Long, ArrayList<Diff>> entry = (Map.Entry<Long, ArrayList<Diff>>) iterator
                        .next();
                if (entry != null) {
                    Iterator iter = entry.getValue().iterator();
                    while (iter.hasNext()) {
                        Diff diff = (Diff) iter.next();
                        StringBuilder sb = new StringBuilder();
                        sb.append(diff.getMeituan_outer_id());
                        sb.append(", ");
                        ++total;
                        fileWriter.write(sb.toString());
                        break;
                    }
                }
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Total count of not match shopid pairs is: " + total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputResult() {
        try {
            int totalCount = 0;
            FileWriter fileWriter = new FileWriter(MODIFIEDOUTPUTCSV);
            FileWriter filePreciseWriter = new FileWriter(
                    MODIFIEDPRECISEOUTPUTCSV);
            StringBuilder head = new StringBuilder();
            head.append("DPPOI\t\t");
            head.append("DPShopID\t");
            head.append("MTShopID\t");
            head.append("DPActNum\t\t");
            head.append("MTActNum\t\t");
            head.append("DPBankActName\t");
            head.append("MTBankActName\n");

            fileWriter.write(head.toString());
            filePreciseWriter.write(head.toString());
            Iterator iterator = modifiedOutputMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Long, ArrayList<Diff>> entry = (Map.Entry<Long, ArrayList<Diff>>) iterator
                        .next();
                if (entry != null) {
                    Iterator iter = entry.getValue().iterator();
                    int count = 0;
                    while (iter.hasNext()) {
                        Diff diff = (Diff) iter.next();
                        fileWriter.write(diff.toString());
                        ++count;
                    }
                    if (count == 1) {
                        ++totalCount;
                        Iterator iter1 = entry.getValue().iterator();
                        Diff diff = (Diff) iter1.next();
                        filePreciseWriter.write(diff.toString());
                    }
                }
            }
            fileWriter.flush();
            filePreciseWriter.flush();
            fileWriter.close();
            filePreciseWriter.close();
            System.out
                    .println("total modifyiedOutputMap with only one dup size is: "
                            + totalCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateMeituanMap() {
        updatedMeiTuanMap = new HashMap<Long, ArrayList<BankInfo>>();
        Iterator iter = dianpingMeituanMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Long, ArrayList<BankInfo>> entry = (Map.Entry<Long, ArrayList<BankInfo>>) iter
                    .next();
            ArrayList<BankInfo> bankInfoDianpingMeituan = entry.getValue();
            Iterator iterator = bankInfoDianpingMeituan.iterator();
            long shopId;
            while (iterator.hasNext()) {
                BankInfo info = (BankInfo) iterator.next();
                shopId = info.getOuterId();
                ArrayList<BankInfo> bankInfoMeituan = originalMeiTuanMap
                        .get(shopId);
                if (bankInfoMeituan != null) {
                    updatedMeiTuanMap.put(entry.getKey(), bankInfoMeituan);
                }
            }
        }
        System.out.println("current updatedMeituan list size is: "
                + updatedMeiTuanMap.size());
        updatedMeiTuanMapCount += updatedMeiTuanMap.size();
    }
}
