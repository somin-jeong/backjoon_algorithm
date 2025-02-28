
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int solution(int n, int[][] computers) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if (i==j) {
                    continue;
                }

                if (computers[i][j] == 1) {
                    if (map.get(i) != null) {
                        map.get(i).add(j);
                    } else {
                        map.put(i, new ArrayList<>());
                        map.get(i).add(j);
                    }
                }
            }
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[computers.length];
        int result = 0;
        for (int k = 0; k < computers.length; k++) {
            if (!visited[k]) {
                result++;

                stack.push(k);
                while (!stack.isEmpty()) {
                    int nowNum = stack.pop();
                    visited[nowNum] = true;

                    if (map.get(nowNum) != null) {
                        map.get(nowNum).sort(Collections.reverseOrder());
                        for (int num : map.get(nowNum)) {
                            if (!visited[num]) {
                                stack.push(num);
                            }
                        }
                    }
                }
            }
        }

        int answer = result;
        return answer;
    }
}