import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(find(n, r, c)+ "\n");
        bw.flush();
        bw.close();
    }

    public static int find(int n, int r, int c) {
        if (n == 1) {
            if (r == 0 && c == 0) {
                return 0;
            } else if (r == 0 && c == 1) {
                return 1;
            } else if (r == 1 && c == 0) {
                return 2;
            } else if (r == 1 && c == 1) {
                return 3;
            }
        }

        n = n-1;

        int result = 0;
        int ractangle_num = 0;
        if (r > Math.pow(2, n) - 1 && c > Math.pow(2, n) - 1) {
            result = find(n, (int) (r-Math.pow(2, n)), (int) (c-Math.pow(2, n)));
            ractangle_num = 3;
        } else if (r > Math.pow(2, n) - 1) {
            result = find(n, (int) (r-Math.pow(2, n)), c);
            ractangle_num = 2;
        } else if (c > Math.pow(2, n) - 1) {
            result = find(n, r, (int) (c-Math.pow(2, n)));
            ractangle_num = 1;
        } else {
            result = find(n, r, c);
            ractangle_num = 0;
        }
        
        return (int) (result + ractangle_num*Math.pow(2, n)*Math.pow(2, n));
    }
}