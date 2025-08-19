import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public static int solution(int[] priorities, int location) {
		int answer = 0;
		ArrayDeque<Integer> queue1 = new ArrayDeque<>();
		for (int i = 1; i <= priorities.length; i++) {
			queue1.add(i);
		}

		ArrayDeque<Integer> queuePriorities = new ArrayDeque<>();
		for (int priority : priorities) {
			queuePriorities.add(priority);
		}

		ArrayList<Integer> result = new ArrayList<>();
		while (result.size() != priorities.length) {
			boolean isExistBigger = false;
			for (Integer queuePriority : queuePriorities) {
				if (queuePriorities.peek() < queuePriority) {
					queue1.add(queue1.poll());
					queuePriorities.add(queuePriorities.poll());
					isExistBigger = true;
					break;
				}
			}
			if (!isExistBigger) {
				result.add(queue1.poll());
				queuePriorities.poll();
			}
		}

		int find = location+1;
		answer = result.indexOf(find)+1;

		System.out.println(answer);
		return answer;
	}
}