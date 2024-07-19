import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        char[][] chess = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char[] array = line.toCharArray();
            chess[i] = array;
        }

        int reprint = 0;
        int min = n*m;
        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                char previousStatus = 'W';
                if (chess[i][j] == 'B') {
                    reprint += 1;
                }
                for (int k = i; k < i+8; k++) {
                    char status = previousStatus;

                    if (i < k) {
                        if (previousStatus == 'W' && chess[k][j] == 'W') {
                            status = 'B';
                            previousStatus = 'B';
                            reprint += 1;
                        } else if (previousStatus == 'B' && chess[k][j] == 'B') {
                            status = 'W';
                            previousStatus = 'W';
                            reprint += 1;
                        } else if (previousStatus == 'B' && chess[k][j] == 'W') {
                            previousStatus = 'W';
                            status = 'W';
                        } else if (previousStatus == 'W' && chess[k][j] == 'B') {
                            previousStatus = 'B';
                            status = 'B';
                        }
                    }
                    for (int l = j+1; l < j+8; l++) {
                        if (chess[k][l]=='B' && status=='W') {
                            status = 'B';
                        } else if (chess[k][l]=='W' && status=='B') {
                            status = 'W';
                        } else if (chess[k][l]=='B' && status=='B'){
                            status = 'W';
                            reprint += 1;
                        } else if (chess[k][l] == 'W' && status == 'W') {
                            status = 'B';
                            reprint += 1;
                        }
                    }
                }
                if (reprint < min) {
                    min = reprint;
                }
                reprint = 0;

                previousStatus = 'B';
                if (chess[i][j] == 'W') {
                    reprint += 1;
                }
                for (int k = i; k < i+8; k++) {
                    char status = previousStatus;

                    if (i < k) {
                        if (previousStatus == 'W' && chess[k][j] == 'W') {
                            status = 'B';
                            previousStatus = 'B';
                            reprint += 1;
                        } else if (previousStatus == 'B' && chess[k][j] == 'B') {
                            status = 'W';
                            previousStatus = 'W';
                            reprint += 1;
                        } else if (previousStatus == 'B' && chess[k][j] == 'W') {
                            previousStatus = 'W';
                            status = 'W';
                        } else if (previousStatus == 'W' && chess[k][j] == 'B') {
                            previousStatus = 'B';
                            status = 'B';
                        }
                    }
                    for (int l = j+1; l < j+8; l++) {
                        if (chess[k][l]=='B' && status=='W') {
                            status = 'B';
                        } else if (chess[k][l]=='W' && status=='B') {
                            status = 'W';
                        } else if (chess[k][l]=='B' && status=='B'){
                            status = 'W';
                            reprint += 1;
                        } else if (chess[k][l] == 'W' && status == 'W') {
                            status = 'B';
                            reprint += 1;
                        }
                    }
                }
                if (reprint < min) {
                    min = reprint;
                }
                reprint = 0;
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}