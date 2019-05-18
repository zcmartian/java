package sort;

public class CountSort {
    public static void countSort(int[] arr,int RANGE) { /**数组中最大的元素不能超过 RANGE*/
        int[] count = new int[RANGE + 1];
        int[] tmp = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            count[arr[i]]++;

        /**现在的count[i]表示小于i的数有count[i]个，排序后元素i就放在第C[i]个输出位置上*/
        for(int i = 1; i <= RANGE; i++)
            count[i] += count[i-1];
        /**
         * 从后向前扫描保证计数排序的稳定性(重复元素相对次序不变)
         * 当再遇到重复元素时会被放在当前元素的前一个位置上保证计数排序的稳定性
         */
        for(int i = arr.length-1; i >= 0; i--)
            tmp[--count[arr[i]]] = arr[i];

        //拷贝回原来的数组
        for(int i = 0; i < arr.length; i++)
            arr[i] = tmp[i];
    }


    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 4, 3};
        countSort(arr, 4);
        for (int i : arr)
            System.out.println(i);
    }
}
