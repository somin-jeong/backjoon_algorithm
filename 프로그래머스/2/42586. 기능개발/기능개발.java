import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
    private static Queue<Integer> queue = new ArrayDeque<>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        for (int i=0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int workingDay = remain / speeds[i];
            if (remain % speeds[i] != 0) {
                workingDay++;
            }
            
            queue.add(workingDay);
        }

        int count = 1;
        int day = 0;
        ArrayList<Integer> list = new ArrayList<>();

        if (!queue.isEmpty()) {
            day = queue.poll();
        }

        while (!queue.isEmpty()) {
            if (day >= queue.peek()) {
                count++;
                queue.poll();
            } else {
                list.add(count);
                count = 1;
                day = queue.poll();
            }

            if (queue.isEmpty()) {
                list.add(count);
                break;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}