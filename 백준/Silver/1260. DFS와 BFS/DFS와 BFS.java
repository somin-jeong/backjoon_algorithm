import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] arg) throws IOException {
        String startLine = br.readLine();
        StringTokenizer st = new StringTokenizer(startLine, " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graphList = new ArrayList[V+1];
        for (int i=1; i<=V; i++) {
            graphList[i] = new ArrayList<>();
        }

        for (int i=1; i<=E; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st2.nextToken());
            int node2 = Integer.parseInt(st2.nextToken());
            graphList[node1].add(node2);
            graphList[node2].add(node1);
        }

        boolean[] visited_dfs = new boolean[V+1];
        String result_dfs = dfs(graphList, visited_dfs, startV, "");
        System.out.println(result_dfs);

        boolean[] visited_bfs = new boolean[V+1];
        String result_bfs = bfs(graphList, visited_bfs, startV);
        System.out.println(result_bfs);

        bw.flush();
        bw.close();
    }

    public static String dfs(ArrayList<Integer>[] graphList, boolean[] visited, int node, String visitedNode) {
        if (!visited[node]) {
            visited[node] = true;
            visitedNode = node + " ";

            Collections.sort(graphList[node]);
            for (int V : graphList[node]) {
                visitedNode += dfs(graphList, visited, V, visitedNode);
            }

            return visitedNode;
        }
        return "";
    }

    public static String bfs(ArrayList<Integer>[] graphList, boolean[] visited, int node) {
        String visitedNodes = "";

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[node] = true;
        queue.add(node);

        while(!queue.isEmpty()) {
            int visitedNode = queue.poll();
            visitedNodes += visitedNode + " ";

            Collections.sort(graphList[visitedNode]);
            for (int V : graphList [visitedNode]) {
                if (!visited[V]) {
                    visited[V] = true;
                    queue.add(V);
                }
            }
        }

        return visitedNodes;
    }


}