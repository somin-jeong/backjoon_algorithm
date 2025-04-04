import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted((o1, o2) -> {
                    if (o1.charAt(n) == o2.charAt(n)) {
                        return o1.compareTo(o2);
                    }

                    return o1.charAt(n) - o2.charAt(n);
                })
                .toArray(String[]::new);
    }
}