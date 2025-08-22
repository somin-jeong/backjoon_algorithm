
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
class Solution {
    public static int solution(int k, int[] tangerine) {
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : tangerine) {
			int count = 0;
			if (map.containsKey(i)) {
				count = map.get(i);
			}
			map.put(i, count+1);
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (Integer value : map.values()) {
			list.add(value);
		}
		list.sort(Collections.reverseOrder());
		int sum = 0;
		for (Integer i : list) {
			if (i < k) {
				sum += i;
				if (k <= sum) {
					answer++;
					return answer;
				}
				answer++;
			} else {
				return 1;
			}

		}
		return answer;
	}
}