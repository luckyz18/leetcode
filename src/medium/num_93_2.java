package medium;

import java.util.ArrayList;
import java.util.List;

//练习
public class num_93_2 {
    public static List<String> restoreIPAddress(String s){
        int[] segmentNum = new int[4];
        List<String> list = new ArrayList<>();
        dfs(s,0,0,segmentNum,list);
        return list;
    }

    public static void dfs(String s, int start, int segId, int[] segmentNum, List<String> list) {
        if (segId == 4){
            StringBuilder sb = new StringBuilder();
            if (start == s.length()){
                for (int i = 0; i < segmentNum.length ; i++) {
                    sb.append(segmentNum[i]);
                    if (i != segmentNum.length-1){
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            return;
        }

        if (start == segmentNum.length){
            return;
        }

        if (s.charAt(start) == '0'){
            segmentNum[segId] = 0;
            dfs(s, start + 1,segId + 1,segmentNum,list);
        }

        //一般情况
        int ipAdd = 0 ;
        for (int i = start; i < s.length() ; i++) {
            ipAdd = ipAdd * 10 + (s.charAt(i) - '0');
            if (ipAdd > 0 && ipAdd <= 255) {
                segmentNum[segId] = ipAdd;
                dfs(s, i + 1, segId + 1, segmentNum, list);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = restoreIPAddress("25525511135");
        System.out.println(list);
    }

}
