import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int countOfCity = Integer.parseInt(br.readLine());
        int countOfTravelCity = Integer.parseInt(br.readLine());

        parent = new int[countOfCity+1];
        for (int i = 1; i < countOfCity + 1; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < countOfCity+1; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");

            for (int j = 1; j < countOfCity+1; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        int parent = find(Integer.parseInt(st.nextToken()));
        while (st.hasMoreTokens()) {
            if (parent != find(Integer.parseInt(st.nextToken()))) {
                bw.write("NO");

                bw.flush();
                bw.close();
                return;
            }
        }

        bw.write("YES");

        bw.flush();
        bw.close();
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return find(parent[x]);
    }

    public static void union(int x, int y) {
        int parent_x = find(x);
        int parent_y = find(y);

        if (parent_x < parent_y) {
            parent[parent_y] = parent_x;
        } else if (parent_x > parent_y) {
            parent[parent_x] = parent_y;
        }
    }
}