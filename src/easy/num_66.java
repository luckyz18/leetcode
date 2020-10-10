package easy;

/**
 * 加一
 */
public class num_66 {
    public static int[] plusOne(int[] digits) {
        if (digits.length >0 && digits[0]==0){
            return new int[]{1};
        }
        for (int i = digits.length-1; i>=0; i--) {
            if (digits[i]!=9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }

    //String-> int 数会超过范围  思路不可行
   /* public static int[] plusOne2(int[] digits) {
        String s="";
        for (int num : digits
             ) {
            s+=num;
        }
        int anInt = Integer.parseInt(s);
        anInt+=1;
        s = anInt+"";
        char[] chars = s.toCharArray();
        int[] intArr = new int[chars.length];
        for(int i=0;i<chars.length;i++){
            intArr[i] = Integer.parseInt(chars[i]+"");
        }
        return intArr;

    }*/

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{9,9,9,9});
        System.out.println(ints);
    }
}
