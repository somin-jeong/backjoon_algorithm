import java.util.ArrayList;

class Solution {
    public static ArrayList<String> list = new ArrayList<>();
	public static char[] array = new char[]{'A', 'E', 'I', 'O', 'U'};
    
    public static int solution(String word) {
		int answer = 0;
		dfs(0, "");
		answer = list.indexOf(word);
		System.out.println(answer+1);
		return answer+1;
	}

	public static void dfs(int n, String s) {
		if (n > 5) {
			return;
		}

		if (s != "") {
			list.add(s);
		}

		for (int i = 0; i < 5; i++) {
			dfs(n+1, s+array[i]);
		}
	}
}