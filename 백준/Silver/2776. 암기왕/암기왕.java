import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int note1NumCount = Integer.parseInt(br.readLine());

            HashSet<Integer> set = new HashSet<>();
            StringTokenizer line1 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < note1NumCount; j++) {
                int num = Integer.parseInt(line1.nextToken());
                set.add(num);
            }

            int note2NumCount = Integer.parseInt(br.readLine());
            StringTokenizer line2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < note2NumCount; j++) {
                int num = Integer.parseInt(line2.nextToken());
                if (set.contains(num)) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}