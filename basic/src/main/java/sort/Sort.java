package sort;

/**
 * Created by Administrator on 2017/2/8.
 */
public class Sort {
    public static void main(String... args) {
        Sort sort = new Sort();
        int[] array = sort.generateArray(11);
        sort.printArray(array);
        System.out.println("Bubble sort :");
//        sort.BubbleSortOne(array);
//        sort.SelectSort(array);
//        sort.InsertSort(array);
        sort.quickSort(array, 0, array.length - 1);
        sort.printArray(array);
    }

    private void BubbleSortOne(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
//            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
            printArray(array);
        }
    }

    private void SelectSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            if (min != i) {
                swap(array, i, min);
            }
            printArray(array);
        }
    }

    private void InsertSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int j = i;
            int target = array[i];

            while (j > 0 && target < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = target;
            printArray(array);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivotKey = array[left];
        int pivotPointer = left;

        while (left < right) {
            while (left < right && array[right] >= pivotKey)
                right--;
            while (left < right && array[left] <= pivotKey)
                left++;
            swap(array, left, right);
        }
        swap(array, pivotPointer, left);
        return left;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int[] generateArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    private void printArray(int[] array) {
        System.out.println("array[] is: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
