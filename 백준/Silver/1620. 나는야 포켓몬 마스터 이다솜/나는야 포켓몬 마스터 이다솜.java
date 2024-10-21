import java.io.*;
import java.util.*;

// poketmon.indexOf(question) -> 시간초과

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int poketmonCount = Integer.parseInt(st.nextToken());
        int questionCount = Integer.parseInt(st.nextToken());

        List<String> poketmon = new ArrayList<>();
        Map<String, Integer> poketmonMap = new HashMap<>();

        for (int i = 0; i < poketmonCount; i++) {
            String s = br.readLine();
            poketmon.add(s);
            poketmonMap.put(s, i);
        }

        String[] questions = new String[questionCount];

        for (int i = 0; i < questionCount; i++) {
            questions[i] = br.readLine();
        }

        for (String question : questions) {
            if (isNumeric(question)) {
                bw.write(poketmon.get(Integer.parseInt(question)-1) + '\n');
            } else {
                int index = poketmonMap.get(question) + 1;
                bw.write(String.valueOf(index) + '\n');
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean isNumeric(String question) {
        try {
            Integer.parseInt(question);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}