import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        char[] chars = line.toCharArray();

        Stack<String> stack = new Stack<>();
        int result = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == '(' && chars[i+1] != ')') {
                stack.push(String.valueOf(chars[i]));
                i++;
            } else if (chars[i] == '(' && chars[i+1] == ')') {
                if (!stack.isEmpty()) {
                    result += stack.size();
                }
                i+=2;
            } else if (chars[i] == ')' && !stack.isEmpty()){
                stack.pop();
                result += 1;
                i++;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}