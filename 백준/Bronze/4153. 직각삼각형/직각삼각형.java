import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line.equals("0 0 0")){
                break;
            }

            StringTokenizer st = new StringTokenizer(line, " ");
            int[] arr = new int[st.countTokens()];

            int i = 0;
            int max = 0;
            while (st.hasMoreTokens()) { // 토큰(문자열)이 존재할 경우 true 리턴
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] > arr[max]) {
                    max = i;
                }
                i++;
            }

            int line1 = 0;
            ArrayList<Integer> rightAngle = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if (j == max) {
                    line1 = arr[j];
                    continue;
                }
                rightAngle.add(arr[j]);
            }

            if (line1*line1 == rightAngle.get(0)*rightAngle.get(0) + rightAngle.get(1)*rightAngle.get(1)) {
                bw.write("right" + "\n");
            } else {
                bw.write("wrong" + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}