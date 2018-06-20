public class BubbleSort {
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            for(int j = i+1;j<n;j++){
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String args[]) {
        int[] arr= {4,8,1,2,9,5};
        sort(arr);
        for (Integer x:arr){
            System.out.print(x+" ");
        }
    }

}
