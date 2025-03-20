import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public long solution(long n) {
        char[] charArray = String.valueOf(n).toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char c : charArray) {
            list.add(c-'0');
        }
        list.sort(Collections.reverseOrder());

        String s = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return Long.parseLong(s);
    }
}