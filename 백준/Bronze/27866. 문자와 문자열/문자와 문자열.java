import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = bf.readLine(); //String
        int num = Integer.parseInt(bf.readLine()); //Int

        String[] array = word.split(""); //공백마다 데이터 끊어서 배열에 넣음
        String s = array[num-1];

        bw.write(s);   // 버퍼에 있는 값 전부 출력
        bw.flush();   // 남아있는 데이터를 모두 출력시킴
        bw.close();   // 스트림을 닫음
    }
}