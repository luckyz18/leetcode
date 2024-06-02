package hot100;

public class Codetop_fib {

    public int fib(int n) {
        int[] f = new int[n+1];
        if (n == 0){
            return 0;
        }
        if (n  == 1){
            return 1;
        }
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        Codetop_fib codetopFib = new Codetop_fib();
        int fib = codetopFib.fib(0);
        System.out.println(fib);
    }
}
