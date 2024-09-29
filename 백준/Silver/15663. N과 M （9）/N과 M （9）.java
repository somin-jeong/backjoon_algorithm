import java.io.*;
import java.util.*;

// 먼저 숫자를 정렬한다.
// before을 사용해서 이전에 접근했던 값을 저장해놓고, 바로 다음 턴에서 사용하지 않도록 한다.

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<String> list = new ArrayList<>();
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
        print();

        bw.flush();
        bw.close();
    }

    static void comb1(List<Integer> arr, boolean[] visited, int[] ans, int n, int r, int depth) throws IOException {
        if(r == 0) {
            save(ans);
        } else {
            int before = -1;
            for(int i = 0; i < n; i++) {
                if (!visited[i] && before!=arr.get(i)) {
                    visited[i] = true;
                    before = arr.get(i);
                    ans[depth] = arr.get(i);
                    comb1(arr, visited, ans, n, r - 1, depth+1);
                    visited[i] = false;
                }
            }
        }
    }

    static void save(int[] ans) throws IOException {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < m; i++) {
            line.append(ans[i]);
            line.append(" ");
        }

        list.add(line.toString());
    }

    static void print() throws IOException {
        for (String s : list) {
            bw.write(s);
            bw.write("\n");
        }
    }
}