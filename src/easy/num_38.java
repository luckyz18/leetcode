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

        if (preNum != null && preNum.length() > 0) {
            char[] charArray = preNum.toCharArray();
            int count = 1;
            StringBuffer res = new StringBuffer("");

            for (int i = 1; i < charArray.length; i++) {
                if (charArray[i] == charArray[i - 1]) {
                    count++;
                } else {
                    res.append(String.valueOf(count) + charArray[i - 1]);
                    count = 1;
                }
            }
            //处理最后一位
            res.append(String.valueOf(count) + charArray[charArray.length - 1]);
            return res.toString();
        }
        return "";
    }

    public static void pushAllDatas() {
        for (int i = 2; i <= 30; i++) {
            String val = getByPre(map.get(i - 1));
            map.put(i, val);
        }
    }

    public static void main(String[] args) {
        String s = countAndSay(6);
        System.out.println(s);
    }
}
