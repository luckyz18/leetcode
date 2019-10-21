package easy;

public class num_77 {
    public static int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        int[] dep = new int[n+1];
        dep[1] = 1;
        dep[2] = 2;
        for (int i = 3; i <=n ; i++) {
            dep[i] = dep[i-1] + dep[i-2];
        }
        return dep[n];
    }
    //超时了。。。
    public static int climbStairs2(int n) {
        return climbStairs2(0,n);
    }
    public static int climbStairs2(int i,int n){
        if (i == n){
            return 1;  //说明这种方法能狗到达
        }
        if (i > n){
            return 0;  //说明这个走不能到达
        }
        return climbStairs2(i+1,n)+climbStairs2(i+2,n);

    }
    // 斐波那契数列
    //套公式


    public static void main(String[] args) {
        System.out.println(climbStairs2(1));

    }

}
