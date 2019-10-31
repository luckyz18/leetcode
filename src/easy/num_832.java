package easy;

public class num_832 {
    /**
     * 先反转再异或 或者  先异或再反转 一样
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        if (A!= null && A.length>0 && A[0].length >0){
            int rowCount = A.length;
            int columnCount = A[0].length;
            for (int i = 0; i <rowCount ; i++) {
                reverseArray(A[i]);
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j]= A[i][j]==0?1:0;
                }
            }
            return A;
        }
        return null;
    }
    public static int[] reverseArray(int[] arr){
        int len = arr.length;
        for (int i = 0; i <len/2 ; i++) {
            int tmp = arr[i];
            arr[i] = arr[len-i-1];
            arr[len-i-1] = tmp;
        }
        return arr;
    }

    /**
     * 思路2
     * 这应该也是作者想要我们想出来的办法
     * 首先我们一行的第一个数，找到它对应的数，也就是这一行最后一个
     * 如果这两个数是不同的，比如说一个是1,一个是0,那么先10反转，则一个是0,一个是1,再左右翻转，又变回一个是1,一个是0
     *      这说明当两个数是不同的时候，不用做任何事情
     *      当两个数相同的时候，要同时异或或被1减，即10反转
     * 注意，循环的范围应该是range(len(row) + 1) // 2)，不能忘了加一。因为，如果列数为奇数，那么中间的数虽然不要左右交换，但是10还是要反转的，因此要多一次循环，相同于中间的数与自己是相同的，要反转。
     */
    public static int[][] flipAndInvertImage2(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <(column+1)/2 ; j++) {
                if (A[i][j] == A[i][column-1-j]){
                    A[i][j] = A[i][column-1-j] = A[i][j] ^ 1;
                }
                //不同则不用做任何操作
            }
        }
        return A;
    }


    public static void main(String[] args) {
        int[][] A = new int[][]{ {1,1,0},{1,0,1},{0,0,0}  };
        int[][] ints = flipAndInvertImage(A);
        System.out.println(ints);

    }
}
