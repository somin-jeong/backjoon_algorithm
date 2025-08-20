import java.util.HashSet;

class Solution {
    public static int result;
    public static HashSet<Integer> set = new HashSet<>();
    
    public static int solution(String numbers) {
		char[] charArray = numbers.toCharArray();
		dfs(charArray, 0, "");
		System.out.println(set.size());
		return set.size();
	}

	public static void dfs(char[] numbers, int n, String c) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != 'A') {
				int num = Integer.parseInt(c + numbers[i]);
				char temp = numbers[i];
				if (isPrime(num)) {
					set.add(num);
				}
				numbers[i] = 'A';
				dfs(numbers, n+1, c + temp);
				numbers[i] = temp;
			}
		}
	}

	public static boolean isPrime(int num) {
		if (num == 1 || num == 0) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}