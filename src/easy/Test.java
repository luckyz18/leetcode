package easy;

import com.sun.org.apache.xpath.internal.functions.FunctionDef1Arg;

import java.util.*;

public class Test {
    static List ids = new LinkedList();

    static String strGroup = "";
    static int count = 0;
    static List ids4Group = new LinkedList();

    public static void run() {
        for (int i = 0; i < ids.size(); i++) {
            strGroup += ids.get(i) + ",";
            count++;
            if (count % 3 == 0 || count == ids.size()) {
                ids4Group.add(strGroup.substring(0, strGroup.length()-1));
                strGroup = "";
            }
        }
    }

    public static void run2() {

    }

    public static void main(String[] args) {
        List arrList = new ArrayList();
        arrList.add("ts");
        arrList.add("ids");
        arrList.add("id_type");
        arrList.add("source");

        Collections.sort(arrList);
        System.out.println(arrList.toString());

    }
}
