package easy;

import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class num_38 {
    static Map<Integer, String> map = new LinkedHashMap();
    static {
        map.put(1, "1");
    }
    public static String countAndSay(int n) {
        pushAllDatas();
        return map.get(n);
    }
    public static String getByPre(String preNum) {
        //看第二种解法吧
       /*if (preNum != null && preNum.length() > 0) {
            char[] charArray = preNum.toCharArray();
            int count = 1;
            StringBuffer res = new StringBuffer("");

            for (int i = 1; i < charArray.length; i++) {
                if (charArray[i] == charArray[i - 1]) {
                    count++;
                } else {
                    res.append(String.valueOf(count) + charArray[i - 1]);  //处理出现不等于时前面的
                    count = 1;
                }
            }
            //处理最后一位
            res.append(String.valueOf(count) + charArray[charArray.length - 1]);
            return res.toString();
        }
        return "";*/

        int count = 1;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < preNum.length(); i++) {
            if (i < preNum.length() - 1 && preNum.charAt(i) == preNum.charAt(i + 1)) {
                count++;
            } else {
                res.append(count).append(preNum.charAt(i));
                count = 1;
            }
        }
        return res.toString();
    }
    public static void pushAllDatas() {
        for (int i = 2; i <= 30; i++) {
            String val = getByPre(map.get(i - 1));
            map.put(i, val);
        }
    }

    public static String countAndSay2(int n) {
       if (n ==1){
           return "1";
       }
       return getByPre(countAndSay(n-1));
    }

    /********************************/
    /*双指针*/
    public static String countAndSay3(int n) {
        String[] str = new String[30];
        str[0] = "1";

        for (int i = 1; i < str.length; i++) {
            String temp = "";
            char[] chars = str[i - 1].toCharArray();
            for (int head = 0, tail = 0; tail <= chars.length; tail++) {
                if (tail < chars.length && chars[head] == chars[tail])
                    continue;
                else {
                    temp = temp + String.valueOf(tail - head) + chars[head];
                    head = tail;
                }
            }
            str[i]=temp;
        }
        return str[n-1];
    }


    public static void main(String[] args) {
        String s = countAndSay3(5);
        System.out.println(s);
    }
}
