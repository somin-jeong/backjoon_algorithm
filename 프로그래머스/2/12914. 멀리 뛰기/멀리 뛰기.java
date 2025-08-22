import java.util.HashMap;
class Solution {
    public static HashMap<Integer, Integer> dp = new HashMap<>();
	public long solution(int n) {
		return fibo(n);
	}

	public static int fibo(int n) {
		if (n == 2) {
			dp.put(2, 2);
			return 2;
		} else if (n == 1) {
			dp.put(1, 1);
			return 1;
		} else if (dp.containsKey(n)) {
			return dp.get(n) % 1234567;
		}

		int value = (fibo(n - 1) + fibo(n - 2)) % 1234567;
		dp.put(n, value);
		return value;
	}
}