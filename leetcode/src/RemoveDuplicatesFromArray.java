/**
 * Created by mars on 2017/3/13.
 */
public class RemoveDuplicatesFromArray {
    public static void main(String ... args) {
        int[] array1 = new int[]{1,1,4,5,7,7,7,8,9,10,34,34};
        RemoveDuplicatesFromArray removeDuplicatesFromArray = new RemoveDuplicatesFromArray();
        System.out.println(removeDuplicatesFromArray.removeDuplicates(array1));
    }

    private int removeDuplicates(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1;i<array.length;++i) {
            if (array[index] != array[i]) {
                array[++index] = array[i];
            }
        }
        return index + 1;
    }
}
