package hot_2018.before;

/**
 * 搜索二维矩阵
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target){
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length-1;
        int column = matrix[0].length-1;
        int startRow = 0;
        int startColumn = column;
        int endRow = row;
        int endColumn = 0;
        while (startRow <= endRow && startColumn >= endColumn){
            if (matrix[startRow][startColumn]  == target){
                return true;
            }else if (matrix[startRow][startColumn]  < target){
                startRow++;
            }else{
                startColumn--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30} }, 20);

        System.out.println(b);
    }
}
