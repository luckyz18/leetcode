package test;

/**
 * 蛇形数组打印
 */
public class SnapMatrix {
    public static void printSnapMatrix(int n){
        int[][] matrix = new int[n][n];
        int num = 1;
        int row = 0;
        int col = n-1;
        int dir = 0; //0->右 1->下 2->左 3->上
        while(num <= n * n){
            matrix[row][col] = num++;
            switch (dir){
                case 0:
                    if( col == n-1 || matrix[row][col+1] != 0){
                        row++;
                        dir = 1;
                    } else{
                        col++;
                    }
                    break;
                case 1:
                    if(row == n-1 || matrix[row+1][col] != 0){
                        col--;
                        dir = 2;
                    } else{
                        row++;
                    }
                    break;
                case 2:
                    if(col ==0 || matrix[row][col-1] != 0){
                        row--;
                        dir = 3;
                    } else{
                        col--;
                    }
                    break;
                case 3:
                    if(row == 0 || matrix[row-1][col] != 0){
                        col++;
                        dir = 0;
                    }else{
                        row--;
                    }
                    break;
            }
        }
        for(int i =0; i<n;i++){
            for (int j = 0; j<n ;j++){
                System.out.print(matrix[i][j] + " ");
                if (j == n-1){
                    System.out.println();
                }

            }
        }
    }

    public static void main(String[] args) {
        printSnapMatrix(4);
    }
}
