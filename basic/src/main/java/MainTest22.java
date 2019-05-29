import java.util.*;

public class MainTest22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amount = 300;

        int[][] prices = {{5, 3}, {3, 2}, {1, 1}};
        Map<Integer, Integer> priceMap = new HashMap<>(2);
        priceMap.put(100, 0);
        priceMap.put(50, 1);
        priceMap.put(0, 2);

        List<List<String>> dataList = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] data = line.split(",");
            dataList.add(Arrays.asList(data));
        }

        for(List<String> data : dataList) {
            int price = Integer.parseInt(data.get(0));
            int pre = Integer.parseInt(data.get(1));
            int act = Integer.parseInt(data.get(2));
            int priceLevel = price >= 100 ? 100 : price >= 50 ? 50 : 0;
            int index = priceMap.get(priceLevel);
            int currentAmount = 0;
            if(act <= 90)
                currentAmount += act * prices[index][0];
            if(act > 90) {
                currentAmount += 90 * prices[index][0];
                currentAmount += (act - 90) * prices[index][1];
            }
            if(act > pre) {
                currentAmount += act - pre;
            }
            currentAmount = Math.min(price, currentAmount);
            amount -= currentAmount;
        }
        System.out.println(amount);
    }
}
