package easy;

/**
 * 二进制求和
 */
public class num_67 {
    public static  String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(),b.length());
        int aLen = a.length();
        int bLen = b.length();
        StringBuilder arr = new StringBuilder("");
        int flag = 0;
        int i = aLen-1, j = bLen-1;
        for (; i >=0 && j>=0; i--,j--) {
            if (a.charAt(i)-'0' + b.charAt(j) + flag >= '2'){
                arr.append(a.charAt(i)-'0' + b.charAt(j) + flag - '2');
                flag = 1;
            }else{
                arr.append(a.charAt(i)-'0' + b.charAt(j) + flag - '0');
                flag=0;
            }
        }
        while (i >= 0){
            if (a.charAt(i) + flag >= '2'){
                arr.append( a.charAt(i) + flag - '2');
                flag = 1;
            }else{
                arr.append(a.charAt(i) + flag - '0');
                flag = 0;
            }
            i--;
        }
        while( j >= 0){
            if (b.charAt(j) + flag >= '2'){
                arr.append( b.charAt(j) + flag -'2');
                flag = 1;
            }else{
                arr.append( b.charAt(j) + flag - '0');
                flag = 0;
            }
            j--;
        }
        if (flag == 1){
            arr.append( 1);
        }
        return String.valueOf(arr.reverse());
    }
    /*****************************/
    public static String addBinary2(String a, String b) {
        StringBuffer res = new StringBuffer("");
        int sum =0;
        int ca = 0;
        for (int i = a.length()-1,j=b.length()-1; i >=0 || j>=0 ; i--,j--) {
            sum  = ca;
            sum += (i>=0 ? a.charAt(i)-'0' : 0);   //用 0 补全
            sum += (j>=0 ? b.charAt(j)-'0' : 0);
            res.append(sum%2);
            ca = sum / 2;  //进位
        }
        res.append(ca == 1 ? 1 : "");
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String sa = addBinary2("1111", "1");
        System.out.println(sa);
    }
}
