import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] count = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeColorPaper(arr, 1, 1, n);

        bw.write(count[0]+ "\n");
        bw.write(count[1]+ "\n");
        bw.flush();
        bw.close();
    }

    public static void makeColorPaper(int[][] arr, int row, int col, int n) {
        if (colorCheck(arr, row, col, n)) {
            if (arr[row][col] == 0) {
                count[0] = count[0] + 1;
            } else {
                count[1] = count[1] + 1;
            }
            return;
        }

        n = n/2;

        makeColorPaper(arr, row, col, n);
        makeColorPaper(arr, row, n+col, n);
        makeColorPaper(arr, n+row, col, n);
        makeColorPaper(arr, n+row, n+col, n);
    }

    // 현재 파티션의 컬러가 같은지 체크한다.
    public static boolean colorCheck(int[][] arr, int row, int col, int size) {

        int color = arr[row][col];	// 첫 번째 원소를 기준으로 검사

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                // 색상이 같이 않다면 false를 리턴
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }
        // 검사가 모두 통과했다는 의미이므로 true 리턴
        return true;
    }
}