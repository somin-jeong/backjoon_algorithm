class Solution {
    public static int result;
    public static int solution(int[] numbers, int target) {
		dfs(numbers, 0, target, 0);
		System.out.println(result);
		return result;
	}

	public static void dfs(int[] numbers, int n, int target, int current_sum) {
		if (n == numbers.length) {
			if (current_sum == target) {
				result++;
			}
			return;
		}

		dfs(numbers, n+1, target, current_sum + numbers[n]);
		dfs(numbers, n+1, target, current_sum - numbers[n]);
	}
}