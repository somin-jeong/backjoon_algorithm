import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int count;
	public static boolean[] visit;
	public static int[] arr;
	public static int minResult;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		count = Integer.parseInt(br.readLine());

		Integer[] arrayA = new Integer[count];
		String lineA = br.readLine();
		StringTokenizer stA = new StringTokenizer(lineA, " ");
		for (int i = 0; i < count; i++) {
			arrayA[i] = Integer.parseInt(stA.nextToken());
		}

		Integer[] arrayB = new Integer[count];
		String lineB = br.readLine();
		StringTokenizer stB = new StringTokenizer(lineB, " ");
		for (int i = 0; i < count; i++) {
			arrayB[i] = Integer.parseInt(stB.nextToken());
		}

		Arrays.sort(arrayA);
		Arrays.sort(arrayB, Collections.reverseOrder());

		int result = 0;
		for (int i = 0; i < count; i++) {
			result += arrayA[i] * arrayB[i];
		}

		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}