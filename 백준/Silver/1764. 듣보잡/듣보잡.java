import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int noListenNum = Integer.parseInt(st.nextToken());
        int noSeeNum = Integer.parseInt(st.nextToken());

        Set<String> list = new HashSet<>();

        for (int i = 0; i < noListenNum; i++) {
            list.add(br.readLine());
        }

        List<String> results = new ArrayList<>();
        for (int i = 0; i < noSeeNum; i++) {
            String line = br.readLine();
            if (list.contains(line)) {
                results.add(line);
            }
        }

        Collections.sort(results);

        bw.write(results.size() + "\n");
        for (String result : results) {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}