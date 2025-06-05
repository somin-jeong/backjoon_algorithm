import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static boolean solution(String[] phone_book) {
		List<String> list = Arrays.stream(phone_book).collect(Collectors.toList());
		list.sort(((o1, o2) -> {
			if (o1.length() > o2.length()) {
				return -1;
			} else if (o1.length() < o2.length()) {
				return 1;
			}
			return 0;
		}));

		HashMap<String, String> map = new HashMap<>();
		for (String s : list) {
			map.put(s, s);
		}

		for (String s : list) {
			for (int i = 1; i < s.length(); i++) {
				if (map.containsKey(s.substring(0, i))) {
					return false;
				}
			}
		}

		boolean answer = true;
		return answer;
	}
}