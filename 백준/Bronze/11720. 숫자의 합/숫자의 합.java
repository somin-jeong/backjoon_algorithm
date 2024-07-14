import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String sNum = br.readLine();

        char[] array = sNum.toCharArray();

        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += array[i] - '0';
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}