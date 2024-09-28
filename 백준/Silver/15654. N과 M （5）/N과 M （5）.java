import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        StringTokenizer line = new StringTokenizer(br.readLine(), " ");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(line.nextToken()));
        }

        Collections.sort(arr);

        boolean[] visited = new boolean[n];
        int[] ans = new int[m];

        comb1(arr, visited, ans, n, m, 0);

        bw.flush();
        bw.close();
    }

    static void comb1(List<Integer> arr, boolean[] visited, int[] ans, int n, int r, int depth) throws IOException {
        if(r == 0) {
            print(ans);
        } else {
            for(int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    ans[depth] = arr.get(i);
                    comb1(arr, visited, ans, n, r - 1, depth+1);
                    visited[i] = false;
                }
            }
        }
    }

    static void print(int[] ans) throws IOException {
        for (int i = 0; i < m; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
    }
}