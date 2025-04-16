class Solution {
    private static int[] parent;

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        int parent_a = find(a);
        int parent_b = find(b);

        if (parent_a > parent_b) {
            parent[parent_a] = parent_b;
        } else if (parent_a < parent_b) {
            parent[parent_b] = parent_a;
        }
    }

    public static void init() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public static int solution(int n, int[][] wires) {
        parent = new int[n+1];
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            init();

            for (int j = 0; j < wires.length; j++) {
                if (i != j) {
                    union(wires[j][0], wires[j][1]);
                }
            }

            int[] count = new int[2];
            int root1 = find(1);
            count[0] = 1;
            for (int j = 2; j < n+1; j++) {
                if (root1 == find(j)) {
                    count[0] = count[0] + 1;
                } else {
                    count[1] = count[1] + 1;
                }
            }

            answer = Math.min(answer, Math.abs(count[0]-count[1]));
        }

        return answer;
    }
}