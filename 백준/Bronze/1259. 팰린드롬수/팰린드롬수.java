import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line.equals("0")){
                break;
            }

            char[] array = line.toCharArray();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < array.length; i++) {
                stack.push(array[i]-'0');
            }

            String newLine = "";
            for (int i = 0; i < array.length; i++) {
                newLine += String.valueOf(stack.pop());
            }

            if (line.equals(newLine)) {
                bw.write("yes" + "\n");
            } else {
                bw.write("no" + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}