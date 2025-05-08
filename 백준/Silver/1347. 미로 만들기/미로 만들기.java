import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[][] visit = new boolean[101][101];
		// for (boolean[] booleans : visit) {
		// 	Arrays.fill(booleans, false);
		// }
		int currentX = 50;
		int currentY = 50;
		visit[currentY][currentX] = true;

		int count = Integer.parseInt(br.readLine());
		String line = br.readLine();

		char currentDir = 'B';
		int dx = 0;
		int dy = 1;

		char[] charArray = line.toCharArray();
		for (char c : charArray) {
			if (c == 'F') {
				currentX += dx;
				currentY += dy;
				visit[currentY][currentX] = true;
			}
			switch (currentDir) {
				case 'B':
					if (c == 'R') {
						dx = -1;
						dy = 0;
						currentDir = 'L';
					} else if (c == 'L') {
						dx = 1;
						dy = 0;
						currentDir = 'R';
					}
					break;
				case 'T' :
					if (c == 'R') {
						dx = 1;
						dy = 0;
						currentDir = 'R';
					} else if (c == 'L') {
						dx = -1;
						dy = 0;
						currentDir = 'L';
					}
					break;
				case 'R' :
					if (c == 'R') {
						dx = 0;
						dy = 1;
						currentDir = 'B';
					} else if (c == 'L') {
						dx = 0;
						dy = -1;
						currentDir = 'T';
					}
					break;
				case 'L' :
					if (c == 'R') {
						dx = 0;
						dy = -1;
						currentDir = 'T';
					} else if (c == 'L') {
						dx = 0;
						dy = 1;
						currentDir = 'B';
					}
					break;
			}
		}

		int startRow = Integer.MAX_VALUE;
		int startCol = Integer.MAX_VALUE;
		int endRow = 0;
		int endCol = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (visit[i][j]) {
					startRow = Math.min(startRow, i);
					startCol = Math.min(startCol, j);
					endRow = Math.max(endRow, i);
					endCol = Math.max(endCol, j);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= endCol; j++) {
				if (visit[i][j]) {
					sb.append(".");
				} else {
					sb.append("#");
				}
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}