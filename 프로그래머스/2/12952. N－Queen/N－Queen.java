import java.util.Arrays;
class Solution {
    private static int count;
    private static int total_n;
    private static Boolean[] visited;
    private static Boolean[] diagonal1;
    private static Boolean[] diagonal2;

    public static int solution(int n) {
        total_n = n;
        visited = new Boolean[n+1];
        diagonal1 = new Boolean[n*2];
        diagonal2 = new Boolean[n*2];
        Arrays.fill(visited, false);
        Arrays.fill(diagonal1, false);
        Arrays.fill(diagonal2, false);
        backtracking(1);
        return count;
    }

    public static void backtracking(int n) {
        if (n == total_n+1) {
            count++;
            return;
        }

        for (int i = 1; i < total_n+1; i++) {
            if (!visited[i] && !diagonal1[n+i-1] && !diagonal2[n-i+total_n]) {
                visited[i] = true;
                diagonal1[n+i-1] = true;
                diagonal2[n-i+total_n] = true;
                backtracking(n+1);
                visited[i] = false;
                diagonal1[n+i-1] = false;
                diagonal2[n-i+total_n] = false;
            }
        }
    }
}