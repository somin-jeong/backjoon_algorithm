import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();


        for (int i = 1; i <= count; i++) {
            queue.add(i);
        }

        Queue<Integer> tempQueue = new LinkedList<>();
        int removeNum = Integer.parseInt(st.nextToken());

        bw.write("<");
        for (int i = 0; i < count; i++) {
            for (int j = 1; j <= removeNum; j++) {
                if (j == removeNum) {
                    if (i == count-1) {
                        bw.write(String.valueOf(queue.poll()));
                    } else {
                        bw.write(queue.poll() + ", ");
                    }
                } else {
                    tempQueue.add(queue.poll());
                }

                if (queue.isEmpty()) {
                    queue = tempQueue;
                }
            }
        }
        // queue 선입선출 <- 1 2
        //                 1 2

        // 3 6 2 7 5 1 4

        bw.write("> ");
        bw.flush();
        bw.close();
    }
}