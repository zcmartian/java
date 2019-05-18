public class RadixSort {
    /**
     * 将整形数按照每位(从低到高)拆分，然后从低位(个位)到高位依次比较各个位，得到所在的位置
     */
    //dn表示最大的数的位数 3位的话只能表示到999
    public static final int dn = 3;

    // 获得元素x的第d位数字
    public static int getDigit(int num,int d) {
        int[] radix = {1,10,100}; //这里只排序总共有三位数,分别代表 个位，十位，百位
        return ( num / radix[d]) % 10;
    }

    //根据数组arr中每个元素 的第d位数,来对整个arr数组排序
    public static void lsdRadixSortInfo(int[] arr,int d) {
        int[] count = new int[10];      //  单独考虑每一个位的时候， 数字都是从[0~9]
        int[] tmp = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
            count[getDigit(arr[i],d)]++;

        for(int i = 1; i < 10; i++)count[i] += count[i-1];

        for(int i = arr.length-1; i >= 0; i--) {
            int digit = getDigit(arr[i],d);  //元素arr[i]当前 的d位的数字为dight
            tmp[--count[digit]] = arr[i];    //根据当前位数字digit来排序，把每个元素A[i]放到它在输出数组B中的正确位置上
        }
        for(int i = 0; i < arr.length; i++)arr[i] = tmp[i];
    }

    public static void lsdRadixSort(int[] arr) {
        for(int d = 0; d < dn; d++) //从低位(个位)到高位 按照每一位排序
            lsdRadixSortInfo(arr, d);
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        lsdRadixSort(arr);
        for (int i : arr)
            System.out.println(i);
    }
}
