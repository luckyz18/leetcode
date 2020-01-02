package hot_2018.array;

//搜索二维矩阵
//时间 O(m+n)
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        int curR = 0;
        int curC = column;
        while (curR <= row && curC >= 0) {
            if (matrix[curR][curC] == target) {
                return true;
            } else if (matrix[curR][curC] < target) {
                curR++;
            } else {
                curC--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
