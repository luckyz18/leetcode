package hot_2018.stack_queue;

public class kthSmallest_3 {
    //快排 可以确定一个位置 跟K比较
    public static int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] arr = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i * col + j] = matrix[i][j];
            }
        }
        int begin = 0, end = arr.length - 1;
        int pos;
        while (begin <= end) {
            pos = partition(arr, begin, end);
            if (pos == k - 1) {
                return arr[pos];
            } else if (pos > k - 1) {
                end = pos - 1;
            } else {
                begin = pos + 1;
            }
        }
        return 0;
    }

    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            swap(arr,left,right);
            while (left < right && arr[left] < temp) {
                left++;
            }
            swap(arr,left,right);
        }
        return left;
    }
    public static void swap(int[]arr,int i,int j){
        if (arr == null || i >= arr.length || j >= arr.length || i < 0 || j < 0) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
