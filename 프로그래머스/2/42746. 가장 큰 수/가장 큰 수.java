import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public String solution(int[] numbers) {
        String[] array = Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .sorted((s1, s2) -> (s2+s1).compareTo(s1+s2))
                .toArray(String[]::new);
        
        if (array[0].equals("0")) return "0";

        String answer = String.join("", array);
        return answer;
    }
}