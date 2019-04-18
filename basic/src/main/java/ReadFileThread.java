import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by marszhou on 16/1/6.
 */
public class ReadFileThread extends Thread {

    @Override
    public void run() {
        String finalI = Thread.currentThread().getName();
        String fileName = Main.MEITUANCSVFOLDER + finalI + ".csv";
        BankInfo bankInfo;
        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("filename:" + fileName);
                String tempString;
                while ((tempString = reader.readLine()) != null) {
                    bankInfo = Main.parseToBankInfo(tempString);
                    if (bankInfo != null) {
                        Long poiId = bankInfo.getPoi_id();
                        ArrayList<BankInfo> bankList = Main.originalMeiTuanMap
                                .get(poiId);
                        if (bankList == null) {
                            bankList = new ArrayList<>();
                            Main.originalMeiTuanMap.put(poiId, bankList);
                        }
                        bankList.add(bankInfo);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
