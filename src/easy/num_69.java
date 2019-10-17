package easy;

//有错
public class num_69 {
    public static int mySqrt(int x) {
        if (x ==0) {
            return 0;
        }
        if (  x==1 || x==2 || x==3){
            return 1;
        }
        long left = 0;
        long right = x/2+1 ;
        while (left < right){
            long mid = (left + right +1)/2;
            long sq = mid * mid;
            if (sq > x){
                right = mid-1;
            }else if (sq == x){
                return (int)mid;
            }else{
                left = mid+1;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
}
