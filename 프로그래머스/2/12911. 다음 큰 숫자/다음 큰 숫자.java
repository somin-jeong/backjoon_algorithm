class Solution {
    public static int solution(int n) {
		String binary = Integer.toBinaryString(n);

		binary = binary.replace("0", "");

		int answer = n;
		for (int i = n+1; i < 1000000; i++) {
			String binary1 = Integer.toBinaryString(i);
			binary1 = binary1.replace("0", "");
			if (binary1.length() == binary.length()) {
				answer = i;
				break;
			}
		}

		return answer;
	}
}