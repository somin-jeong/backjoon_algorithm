import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            if (!list.contains(line)) {
                list.add(line);
            }
        }

        Comparator<String> c = new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {
                    return 1;
                } else if (s1.length() == s2.length() && s1.compareTo(s2) > 0) {
                    return 1;
                } else if (s1.length() == s2.length() && s1.compareTo(s2) == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };

        Collections.sort(list, c);

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i)+ "\n");
        }

        bw.flush();
        bw.close();
    }
}