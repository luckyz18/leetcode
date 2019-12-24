package hot_2018.string;

/**
 * 反转字符串
 * 要求空间复杂度是 O(1)
 */
public class ReverseString {
    public void reverseString(char[] s){
        int i = 0;
        int j = s.length-1;
        while (i <= j ){
            swap(s,i++,j--);
        }
        System.out.println();
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        ReverseString A = new ReverseString();
        A.reverseString("Hannah".toCharArray());
    }
}
