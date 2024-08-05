import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            map.put(line, i);
            list.add(line);
        }

        Comparator<String> c = (s1, s2) -> {
            StringTokenizer line1 = new StringTokenizer(s1, " ");
            int age1 = Integer.parseInt(line1.nextToken());
            String name1 = line1.nextToken();

            StringTokenizer line2 = new StringTokenizer(s2, " ");
            int age2 = Integer.parseInt(line2.nextToken());
            String name2 = line2.nextToken();

            if (age1 > age2) {
                return 1;
            } else if (age1 == age2) {
                return 0;
            } else {
                return -1;
            }
        };

        list.sort(c);

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i)+ "\n");
        }

        bw.flush();
        bw.close();
    }
}