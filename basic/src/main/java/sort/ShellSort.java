package sort;

public class ShellSort {
    public static void shellSort(int[] arr) {
        for(int gap = arr.length;gap>0;gap/=2) {
            for(int i=gap;i<arr.length;i++) {
                int key = arr[i], j;
                for(j = i - gap;j>=0 && key < arr[j]; j-=gap)
                    arr[j + gap] = arr[j];
                arr[j+gap] = key;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        shellSort(arr);
    }
}
