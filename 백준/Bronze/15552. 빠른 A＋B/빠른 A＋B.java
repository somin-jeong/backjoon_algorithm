import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(bf.readLine());
        for (int i = 0; i < count; i++) {
            String line = bf.readLine();

            StringTokenizer st = new StringTokenizer(line); //StringTokenizer인자값에 입력 문자열 넣음
            int num1 = Integer.parseInt(st.nextToken()); //첫번째 호출
            int num2 = Integer.parseInt(st.nextToken()); //두번째 호출

            int sum = num1 + num2;
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}