import java.util.Arrays;
class Solution {
    private int dungeons_count;
    private long result;

    public int solution(int k, int[][] dungeons) {
        dungeons_count = dungeons.length;
        Boolean[] visited = new Boolean[dungeons_count];
        Arrays.fill(visited, false);
        backtracking(k, dungeons, visited);

        return (int) result;
    }

    public void backtracking(int k, int[][] dungeons, Boolean[] visited) {
        for (int i = 0; i < dungeons_count; i++) {
            if (visited[i]) {
                continue;
            }

            if (dungeons[i][0] <= k) {
                Boolean[] arr = Arrays.copyOf(visited, dungeons_count);
                arr[i] = true;
                backtracking(k-dungeons[i][1], dungeons, arr);

                long count = Arrays.stream(arr).filter(aBoolean -> aBoolean).count();
                if (result < count) {
                    result = count;
                }
            }
        }
    }
}