import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<int[]> queen = new ArrayList<>();
	static List<int[]> knight = new ArrayList<>();
	static List<int[]> pawn = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String size = br.readLine();
		StringTokenizer st1 = new StringTokenizer(size, " ");
		int rowSize = Integer.parseInt(st1.nextToken());
		int colSize = Integer.parseInt(st1.nextToken());

		char[][] chess = new char[rowSize][colSize];

		String line1 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(line1, " ");
		int qCount = Integer.parseInt(st2.nextToken());
		for (int i = 0; i < qCount; i++) {
			int qRow = Integer.parseInt(st2.nextToken());
			int qCol = Integer.parseInt(st2.nextToken());
			chess[qRow-1][qCol-1] = 'q';
			queen.add(new int[]{qRow-1, qCol-1});
		}

		String line2 = br.readLine();
		StringTokenizer st3 = new StringTokenizer(line2, " ");
		int kCount = Integer.parseInt(st3.nextToken());
		for (int i = 0; i < kCount; i++) {
			int kRow = Integer.parseInt(st3.nextToken());
			int kCol = Integer.parseInt(st3.nextToken());
			chess[kRow-1][kCol-1] = 'k';
			knight.add(new int[]{kRow-1, kCol-1});
		}

		String line3 = br.readLine();
		StringTokenizer st4 = new StringTokenizer(line3, " ");
		int pCount = Integer.parseInt(st4.nextToken());
		for (int i = 0; i < pCount; i++) {
			int pRow = Integer.parseInt(st4.nextToken());
			int pCol = Integer.parseInt(st4.nextToken());
			chess[pRow-1][pCol-1] = 'p';
		}

		for (int[] qPosition : queen) {
			int qRow = qPosition[0];
			int qCol = qPosition[1];
			for (int i = qCol-1; i >= 0; i--) {
				if (chess[qRow][i] == 'k' || chess[qRow][i] == 'p' || chess[qRow][i] == 'q') {
					break;
				}
				chess[qRow][i] = 'O';
			}

			for (int i = qCol+1; i < colSize; i++) {
				if (chess[qRow][i] == 'k' || chess[qRow][i] == 'p' || chess[qRow][i] == 'q') {
					break;
				}
				chess[qRow][i] = 'O';
			}

			for (int i = qRow+1; i < rowSize; i++) {
				if (chess[i][qCol] == 'k' || chess[i][qCol] == 'p' || chess[i][qCol] == 'q') {
					break;
				}
				chess[i][qCol] = 'O';
			}

			for (int i = qRow-1; i >= 0; i--) {
				if (chess[i][qCol] == 'k' || chess[i][qCol] == 'p' || chess[i][qCol] == 'q') {
					break;
				}
				chess[i][qCol] = 'O';
			}

			for (int i = 1; i < Math.min(rowSize, colSize); i++) {
				if (qRow+i >= rowSize || qRow+i < 0 || qCol+i >= colSize || qCol+i < 0 ||
					chess[qRow+i][qCol+i] == 'k' || chess[qRow+i][qCol+i] == 'p' || chess[qRow+i][qCol+i] == 'q') {
					break;
				}
				chess[qRow+i][qCol+i] = 'O';
			}

			for (int i = 1; i < Math.min(rowSize, colSize); i++) {
				if (qRow-i >= rowSize || qRow-i < 0 || qCol-i >= colSize || qCol-i < 0 ||
					chess[qRow-i][qCol-i] == 'k' || chess[qRow-i][qCol-i] == 'p' || chess[qRow-i][qCol-i] == 'q') {
					break;
				}
				chess[qRow-i][qCol-i] = 'O';
			}
			for (int i = 1; i < Math.min(rowSize, colSize); i++) {
				if (qRow+i >= rowSize || qRow+i < 0 || qCol-i >= colSize || qCol-i < 0 ||
					chess[qRow+i][qCol-i] == 'k' || chess[qRow+i][qCol-i] == 'p' || chess[qRow+i][qCol-i] == 'q') {
					break;
				}
				chess[qRow+i][qCol-i] = 'O';
			}
			for (int i = 1; i < Math.min(rowSize, colSize); i++) {
				if (qRow-i >= rowSize || qRow-i < 0 || qCol+i >= colSize || qCol+i < 0 ||
					chess[qRow-i][qCol+i] == 'k' || chess[qRow-i][qCol+i] == 'p' || chess[qRow-i][qCol+i] == 'q') {
					break;
				}
				chess[qRow-i][qCol+i] = 'O';
			}
		}

		int[][] possible = new int[][]{{2,-1}, {-2, 1}, {2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, -2}, {-1, 2}};
		for (int[] kPosition : knight) {
			int kRow = kPosition[0];
			int kCol = kPosition[1];

			for (int[] position : possible) {
				if (kRow+position[0] >= rowSize || kRow+position[0] < 0 || kCol+position[1] >= colSize || kCol+position[1] < 0 ||
					chess[kRow+position[0]][kCol+position[1]] == 'k' ||
					chess[kRow+position[0]][kCol+position[1]] == 'p' ||
					chess[kRow+position[0]][kCol+position[1]] == 'q') {
					continue;
				}
				chess[kRow+position[0]][kCol+position[1]] = 'O';
			}
		}

		int result = 0;
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (chess[i][j] != 'k' && chess[i][j] != 'p' && chess[i][j] != 'q' && chess[i][j] != 'O') {
					result++;
				}
			}
		}

		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}