import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Float> failRate = new HashMap<>();
        for (int i = 1; i < N+1; i++) {
            int totalChallenger = 0;
            int failCount = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i) {
                    totalChallenger++;
                }
                if (stages[j] == i) {
                    failCount++;
                }
            }
            if (totalChallenger == 0 || failCount == 0) {
                failRate.put(i, 0.0F);
                continue;
            }
            failRate.put(i, (float) failCount / (float) totalChallenger);
        }

        List<Integer> stageList = new ArrayList<>(failRate.keySet());
        stageList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (failRate.get(o1) < failRate.get(o2)) {
                    return 1;
                }
                if (Objects.equals(failRate.get(o1), failRate.get(o2)) && o1 > o2) {
                    return 1;
                }
                if (failRate.get(o1) > failRate.get(o2)) {
                    return -1;
                }
                return 0;
            }
        });

        return stageList.stream().mapToInt(Integer::intValue).toArray();
    }
}