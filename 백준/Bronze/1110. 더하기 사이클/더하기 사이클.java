import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        String numString = String.valueOf(num);
        if (num < 10) {
            numString = "0" + num;
        }

        int count = 0;
        while (true) {
            count ++;
            char[] array = numString.toCharArray();
            String first = String.valueOf(array[0]);
            String last = String.valueOf(array[1]);
            int sum = Integer.parseInt(first) + Integer.parseInt(last);

            char[] array2 = String.valueOf(sum).toCharArray();
            String newLast = "";
            for (int i = 0; i < array2.length; i++) {
                newLast = String.valueOf(array2[i]);
            }

            String newNum = last + newLast;
            if (Integer.parseInt(newNum) == num) {
                break;
            }
            numString = newNum;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}
