package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Code_flexport_meetingroom {

    public static class Conference {
        int start;
        int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Conference{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public List<Conference> scheduleConferences(List<Conference> conferences) {
        if (conferences == null || conferences.isEmpty()) {
            return conferences;
        }

        // 先按照开始时间排序
        conferences.sort(Comparator.comparingInt(Conference::getStart));

        List<Conference> scheduledConferences = new ArrayList<>();
        for (Conference conf : conferences) {
            boolean conflictFound = false;
            for (Conference scheduledConf : scheduledConferences) {
                if (conf.start <= scheduledConf.end) {
                    // 如果有冲突，尝试合并
                    scheduledConf.end = Math.max(scheduledConf.end, conf.end);
                    conflictFound = true;
                    break;
                }
            }
            // 如果没有冲突，直接添加到已安排的会议列表
            if (!conflictFound) {
                scheduledConferences.add(conf);
            }
        }

        return scheduledConferences;
    }

    public static void main(String[] args) {
        Code_flexport_meetingroom scheduler = new Code_flexport_meetingroom();
        List<Conference> conferences = Arrays.asList(
                new Conference(1, 3),
                new Conference(2, 6),
                new Conference(4, 5),
                new Conference(5, 7)
        );
        List<Conference> scheduled = scheduler.scheduleConferences(conferences);
        for (Conference conf : scheduled) {
            System.out.println(conf);
        }
    }

}
