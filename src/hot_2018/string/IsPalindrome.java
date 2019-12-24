package hot_2018.string;

/**
 * 验证是否是回文字符串
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int p = 0;
        int q = s.length() - 1;
        while (q > p) {
            char c1 = s.charAt(p);
            char c2 = s.charAt(q);

            if (!((c1 >= '0' && c1 <= '9') || (c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z'))) {
                p++;
                continue;
            }

            if (!((c2 >= '0' && c2 <= '9') || (c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z'))) {
                q--;
                continue;
            }
            if (!(c1 + "").equalsIgnoreCase(c2 + "")) {
                return false;
            }
            p++;
            q--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome("  ");
        System.out.println(palindrome);
    }
}
