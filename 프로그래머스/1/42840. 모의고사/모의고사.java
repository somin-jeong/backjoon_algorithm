import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] result = new int[3];
        for (int student = 0; student < pattern.length; student++) {
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == pattern[student][i % pattern[student].length]) {
                    result[student]++;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int max = Arrays.stream(result).max().orElse(0);
        for (int i = 0; i < result.length; i++) {
            if (max == result[i]) {
                list.add(i+1);
            }
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}