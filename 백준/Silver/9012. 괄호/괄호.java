import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String line = br.readLine();

            char[] array = line.toCharArray();

            Stack<String> stack = new Stack<>();
            for (int j = 0; j < array.length; j++) {
                if (array[j] == '(') {
                    stack.push(String.valueOf(array[j]));
                } else if (array[j] == ')' && !stack.empty()){
                    stack.pop();
                } else if (array[j] == ')' && stack.empty()) {
                    bw.write("NO" + "\n");
                    break;
                }

                if (j == array.length-1) {
                    if (!stack.empty()) {
                        bw.write("NO" + "\n");
                    } else {
                        bw.write("YES" + "\n");
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }
}