package sort;

public class HeapSort {
    public static void siftDown(int[] arr,int i,int size) { //从A[i] 开始往下调整
        int L = 2*i+1; //左孩子的下标
        int R = 2*i+2;//右孩子的下标
        int maxIdx = i;
        if(L < size && arr[L] > arr[maxIdx])maxIdx = L;
        if(R < size && arr[R] > arr[maxIdx])maxIdx = R;
        if(maxIdx != i) {
            swap(arr,i,maxIdx);  //把当前结点和它的最大(直接)子节点进行交换
            siftDown(arr,maxIdx,size);  //继续调整它的孩子
        }
    }

    public static void heapSort2(int[] arr) {
        int size = arr.length - 1;
        for(int i = (size-1)/2; i >= 0; i--)
            siftDown(arr,i,size+1);
        swap(arr,0,size);//和最后一个数交换
        while(size > 0){
            siftDown(arr,0,size);
            swap(arr,0,--size);
        }
    }

    private static void swap(int[] arr, int L, int R) {
        int tmp = arr[L];
        arr[L] = arr[R];
        arr[R] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        heapSort2(arr);
        for (int i : arr)
            System.out.println(i);
    }
}
