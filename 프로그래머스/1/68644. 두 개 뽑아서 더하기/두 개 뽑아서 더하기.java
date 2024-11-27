import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                arr.add(numbers[i] + numbers[j]);
            }
        }
        
        Collections.sort(arr);
        int[] answer = arr.stream().distinct().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}