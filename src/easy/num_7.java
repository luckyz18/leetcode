package easy;

//整数反转
/**
 * 1. 转换成字符串处理，越界就用try catch 判断
 * 2. 官方：res > MAX_VALUE/10  ||
 *      res = MAX_VALUE/10 && pop > MAX_VALUE%10  最小同理
 */
public class num_7 {
    public static int reverse(int x) {

        try {
            String s = String.valueOf(x);
            char[] c = s.toCharArray();
            int len = c.length;
            int mid = len / 2;
            for (int i = 0; i < mid; i++) {
                tranverse(c, i, len - 1 - i);
            }
            //判断 第一项是不是0  和最后一项是不是-、
            String p = "";
            if (c[len-1] == '-') {
                len = len - 1;
                p = "-";
            }
            String l = "";
            boolean f = false;
            for (int i = 0; i < len; i++) {
                if (c[i] == '0' && f== false) {
                    continue;
                }
                f = true;
                l += c[i];
            }
            String res = String.valueOf(p + l);
            int a = Integer.parseInt(res);
            return a;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void tranverse(char[] c, int i, int j) {
        char temp = c[j];
        c[j] = c[i];
        c[i] = temp;
    }

    public static void main(String[] args) {
        int b = reverse(90100);
        System.out.println(b);

    }
}
