class Solution {
    public static int[] solution(int brown, int yellow) {
		int width = 0;
		int length = 0;

		for (int i = 1; i <= yellow; i++) {
			int countOfBrown = 4;
			if (yellow%i == 0) {
				countOfBrown += i*2;
				countOfBrown += (yellow/i)*2;

				if (countOfBrown == brown) {
					width = Math.max(i, yellow/i) + 2;
					length = Math.min(i, yellow/i) + 2;
					break;
				}
			}
		}

		int[] answer = {width, length};
		return answer;
	}
}