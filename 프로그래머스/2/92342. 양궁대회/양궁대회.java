import java.util.Arrays;
class Solution {
    public static int count;
	public static int[] apeach;
	public static int dif_score = -1;
	public static int[] lion_result;

	public static int[] solution(int n, int[] info) {
		count = n;
		apeach = info;
		lion_result = new int[11];
		Arrays.fill(lion_result, 0);
		int[] lion = new int[11];
		Arrays.fill(lion, 0);
		backtracking(0, 0, lion);

		if (dif_score <= 0) {
			int[] answer = {-1};
			return answer;
		}

		return lion_result;
	}

	// 백트랙킹을 통해 가능한 라이언의 과녁 점수 조합의 모든 경우를 구함
	public static void backtracking(int n, int idx, int[] lion) {
		if (n == count) {
			calculateDiff(lion);
			return;
		}

		for (int i = idx; i < 11; i++) {
			lion[i] = lion[i] + 1;
			backtracking(n+1, i, lion);
			lion[i] = lion[i] - 1;
		}
	}

	private static void calculateDiff(int[] lion) {
		int a_score = 0;
		int l_score = 0;
		int j = 0;
		for (int i = 10; i >= 0; i--) {
			if (apeach[i] == 0 && lion[i] == 0) {
				j++;
				continue;
			}
			if (apeach[i] < lion[i] && lion[i] != 0) {
				l_score += j;
			} else if (apeach[i] != 0) {
				a_score += j;
			}
			j++;
		}

		// 최대 차이와 라이언의 과녁 저장
		if (dif_score < l_score - a_score) {
			dif_score = l_score - a_score;
			lion_result = Arrays.copyOf(lion, 11);
		} else if (dif_score == l_score - a_score) { // 점수가 같으면 더 많이 맞힌 경우를 찾음
			dif_score = l_score - a_score;
			for (int i = 10; i >= 0; i--) {
				if (lion_result[i] < lion[i]) {
					lion_result = Arrays.copyOf(lion, 11);
					break;
				} else if (lion_result[i] > lion[i]) {
					break;
				}
			}
		}
	}
}