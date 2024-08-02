import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++) {
            int dotCount = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            HashSet<Integer> set = new HashSet<>();
            Integer[] list = new Integer[testCount];
            for (int k = 0; k < dotCount; k++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            list = set.toArray(list);
            int result = 0;
            for (int j = 0; j < dotCount-1; j++) {
                for (int k = j+1; k < dotCount; k++) {
                    if (Math.abs(list[j] - list[k]) % 2 == 0) {
                        int medium = Math.abs(list[j] - list[k]) / 2;
                        int findNum = Math.min(list[j], list[k]) + medium;
                        if (set.contains(findNum)) {
                            result += 1;
                        }
                    }
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}