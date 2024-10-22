import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cardCount = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        Map<Integer, Integer> cardMap = new HashMap<>();
        for (int i = 0; i < cardCount; i++) {
            int cardNum = Integer.parseInt(st1.nextToken());
            if (cardMap.containsKey(cardNum)) {
                cardMap.put(cardNum, cardMap.get(cardNum) + 1);
            } else {
                cardMap.put(cardNum, 1);
            }
        }

        int questionCount = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < questionCount; i++) {
            Integer question = Integer.parseInt(st2.nextToken());
            Integer result = cardMap.get(question);
            if (result != null) {
                bw.write(result + " ");
            } else {
                bw.write(0 + " ");
            }

        }

        bw.flush();
        bw.close();
    }
}
