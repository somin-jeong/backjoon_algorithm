import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            queue.add(i);
        }

        int result = 1;
        while (true) {
            queue.poll();

            if (queue.isEmpty()) {
                break;
            }

            result = queue.poll();
            queue.add(result);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}