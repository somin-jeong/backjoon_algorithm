import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[][] visit = new boolean[6][6];
		for (boolean[] booleans : visit) {
			Arrays.fill(booleans, false);
		}

		String first = br.readLine();
		char[] firstArray = first.toCharArray();
		int firstCol = firstArray[0] - 'A' + 1;
		int firstRow = firstArray[1] - '0';

		int currentCol = firstCol;
		int currentRow = firstRow;

		String result = "Valid";
		for (int i = 0; i < 35; i++) {
			String next = br.readLine();
			char[] nextArray = next.toCharArray();
			int nextCol = nextArray[0] - 'A' + 1;
			int nextRow = nextArray[1] - '0';
			if (visit[nextRow-1][nextCol-1]) {
				result = "Invalid";
				break;
			}

			if (Math.abs(currentCol-nextCol)==1 && Math.abs(currentRow-nextRow)==2
					|| Math.abs(currentCol-nextCol)==2 && Math.abs(currentRow-nextRow)==1) {
				currentCol = nextCol;
				currentRow = nextRow;
				visit[currentRow-1][currentCol-1] = true;
			} else {
				result = "Invalid";
				break;
			}

			if (i == 34 && !(Math.abs(firstCol-nextCol)==1 && Math.abs(firstRow-nextRow)==2)
				&& !(Math.abs(firstCol-nextCol)==2 && Math.abs(firstRow-nextRow)==1)) {
				result = "Invalid";
				break;
			}
		}

		bw.write(result);
		bw.flush();
		bw.close();
	}
}