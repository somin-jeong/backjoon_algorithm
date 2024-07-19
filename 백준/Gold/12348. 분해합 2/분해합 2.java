import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long num = Long.parseLong(br.readLine());

        long result = 0;
        if (num <= 18*9) {
            long sum = 0;
            for (int i = 0; i < 18 * 9; i++) {
                sum = sum + i;
                char[] array = String.valueOf(i).toCharArray();

                for (int j = 0; j < array.length; j++) {
                    sum += Integer.parseInt(String.valueOf(array[j]));
                }

                if (num == sum) {
                    result = i;
                    break;
                }
                sum = 0;
            }
        } else {
            long sum = 0;
            for (long i = num-(18*9); i < num; i++) {
                sum = sum + i;
                char[] array = String.valueOf(i).toCharArray();

                for (int j = 0; j < array.length; j++) {
                    sum += Long.parseLong(String.valueOf(array[j]));
                }

                if (num == sum) {
                    result = i;
                    break;
                }
                sum = 0;
            }
        }

        bw.write(String.valueOf(result) + "\n");
        bw.flush();
        bw.close();
    }
}