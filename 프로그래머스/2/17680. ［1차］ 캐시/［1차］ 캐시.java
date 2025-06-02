
import java.util.ArrayDeque;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayDeque<String> queue = new ArrayDeque<>();
		int executionTime = 0;
		for (String city : cities) {
			city = city.toLowerCase();
			if (queue.contains(city)) {
				executionTime++;
				queue.add(city);
				queue.remove(city);
			} else {
				executionTime += 5;
				queue.add(city);
				if (queue.size() > cacheSize) {
					queue.poll();
				}
			}
		}

		int answer = executionTime;
		return answer;
    }
}