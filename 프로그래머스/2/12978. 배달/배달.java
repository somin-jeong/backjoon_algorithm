import java.util.Arrays;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int[] cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        boolean[] visited = new boolean[N+1];

        cost[1] = 0;

        for (int j=0; j<N-1; j++) {
            // 방문하지 않은 노드 중 최소 비용이 가장 적은 노드 선택
            int min_node = 0;
            int min = Integer.MAX_VALUE;
            for (int i=0; i<cost.length; i++) {
                if (!visited[i] && cost[i] < min) {
                    min = cost[i];
                    min_node = i;
                }
            }
            visited[min_node] = true;

            // 최소 비용이 가장 적은 노드를 거쳐서 각 노드까지 가는 비용이 현재까지 구한 최소 비용보다 작으면 cost 배열에 저장한다.
            for (int[] node : road) {
                if (node[0] == min_node && cost[node[1]] > cost[min_node]+node[2]) {
                    cost[node[1]] = cost[min_node]+node[2];  // 최소 비용 저장
                }

                if (node[1] == min_node && cost[node[0]] > cost[min_node]+node[2]) {
                    cost[node[0]] = cost[min_node]+node[2];  // 최소 비용 저장
                }
            }
        }

        int answer = 0;
        for (int j : cost) {
            if (j <= K) {
                answer++;
            }
        }

        return answer;
    }
}