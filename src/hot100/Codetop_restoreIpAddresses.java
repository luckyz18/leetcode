package hot100;

import java.util.ArrayList;
import java.util.List;

public class Codetop_restoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtrack(result, s, list, 0);
        return result;
    }

    public void backtrack(List<String> result, String s ,List<String> current, int start){
        if(current.size() == 4 && start == s.length()){
            result.add(String.join(".", current));
            return;
        }
        for(int i = 1; i<4; i++){ //每部分最多包含三个数字
            if(start + i > s.length()){
                break;
            }
            String part = s.substring(start, start + i);
            if((part.startsWith("0") && part.length() > 1) || Integer.parseInt(part) > 255){
                continue;
            }
            current.add(part);
            backtrack(result, s, current, start + i);
            //回溯 移除当前部分，尝试其他切割点
            current.remove(current.size() - 1);
        }
    }

    public static void main (String[] args){
        Codetop_restoreIpAddresses instance = new Codetop_restoreIpAddresses();
        List<String> result = instance.restoreIpAddresses("25525511135");
        for(String ip : result){
            System.out.println(ip);
        }
    }
}
