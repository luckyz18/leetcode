package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个思路：
 * 1. 往前看  遍历i位置 如果前边那个数小于它 就减去那个数 * 2  即先加后减
 * 2. 往后看  遍历i  跟后边的数比较  如果小 就减去当前值
 */
public class num_13 {
    public static int romanToInt(String s) {
        HashMap<Object, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int size = s.length();
        int res = 0;
        //往前看
        for (int i = 0; i < size; i++) {
            if (i != 0 && (map.get(s.charAt(i)) > map.get(s.charAt(i - 1)))) {
                res = (res - map.get(s.charAt(i - 1)) * 2 + map.get(s.charAt(i))); //忘了加当前位置的数
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }

    //2.
    public int romanToInt2(String s1) {
        int n = s1.length();
        int roman_int = 0;
        for (int i = 0; i < n; i++) {
            switch (s1.charAt(i)) {
                case 'I': roman_int = roman_int + 1;
                    break;
                case 'V':roman_int = roman_int + 5;
                    break;
                case 'X':   roman_int = roman_int + 10;
                    break;
                case 'L':   roman_int = roman_int + 50;
                    break;
                case 'C':    roman_int = roman_int + 100;
                    break;
                case 'D':    roman_int = roman_int + 500;
                    break;
                case 'M':  roman_int = roman_int + 1000;
                    break;
                default:    System.out.println("default");
                    break;
            }
            if (i != 0) {
                if (((s1.charAt(i) == 'V') || (s1.charAt(i) == 'X')) && (s1.charAt(i - 1) == 'I'))
                    roman_int = roman_int - 1 * 2;
                if (((s1.charAt(i) == 'L') || (s1.charAt(i) == 'C')) && (s1.charAt(i - 1) == 'X'))
                    roman_int = roman_int - 10 * 2;
                if (((s1.charAt(i) == 'D') || (s1.charAt(i) == 'M')) && (s1.charAt(i - 1) == 'C'))
                    roman_int = roman_int - 100 * 2;
            }
        }
        return roman_int;
    }
    //3.
    public int romanToInt3(String s2) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for(int i = 0;i < s2.length();) {
            if(i + 1 < s2.length() && map.containsKey(s2.substring(i, i+2))) {
                ans += map.get(s2.substring(i, i+2));
                i += 2;
            } else {
                ans += map.get(s2.substring(i, i+1));
                i ++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int mcmxciv = romanToInt("IX");
        System.out.println(mcmxciv);
    }
}
