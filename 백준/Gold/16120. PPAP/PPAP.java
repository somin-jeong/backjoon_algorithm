import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        char[] chars = line.toCharArray();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(String.valueOf(chars[i]));

            if (list.size() >= 4) {
                if (list.get(list.size()-4).equals("P") && list.get(list.size()-3).equals("P") && list.get(list.size()-2).equals("A") && list.get(list.size()-1).equals("P")) {
                    if (i == chars.length-1) {
                        break;
                    }
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                }
            }
        }

        String result = String.join("", list);

        if (result.equals("PPAP") || result.equals("P")) {
            bw.write("PPAP" + "\n");
        } else {
            bw.write("NP" + "\n");
        }

        bw.flush();
        bw.close();
    }
}