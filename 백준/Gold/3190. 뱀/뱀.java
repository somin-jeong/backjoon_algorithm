import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		int appleSize = Integer.parseInt(br.readLine());
		int[][] board = new int[size][size];  // 2 snake, 1 apple
		for (int i = 0; i < appleSize; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			board[row-1][col-1] = 1;
		}

		int snakeDirSize = Integer.parseInt(br.readLine());
		Map<Integer, String> snakeDir = new HashMap<>();
		for (int i = 0; i < snakeDirSize; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			snakeDir.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 오, 왼, 아, 위
		int row = 0;
		int col = 0;
		int direction = 0;
		int time = 0;
		board[0][0] = 2;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{row, col});
		while (true) {
			time++;
			row += dirs[direction][0];
			col += dirs[direction][1];

			if (row >= size || row < 0 || col >= size || col < 0 || board[row][col] == 2) {  // 벽
				break;
			}

			if (board[row][col] == 1) {  // 사과 있을 때
				board[row][col] = 2;
				queue.add(new int[]{row, col});
			} else {
				board[row][col] = 2;
				queue.add(new int[]{row, col});
				int[] poll = queue.poll();
				if (poll != null) {
					board[poll[0]][poll[1]] = 0;
				}
			}

			if (snakeDir.containsKey(time)) {
				if (direction == 0 && Objects.equals(snakeDir.get(time), "D")) {
					direction = 2;
					continue;
				}
				if (direction == 0 && Objects.equals(snakeDir.get(time), "L")) {
					direction = 3;
					continue;
				}
				if (direction == 1 && Objects.equals(snakeDir.get(time), "D")) {
					direction = 3;
					continue;
				}
				if (direction == 1 && Objects.equals(snakeDir.get(time), "L")) {
					direction = 2;
					continue;
				}
				if (direction == 2 && Objects.equals(snakeDir.get(time), "D")) {
					direction = 1;
					continue;
				}
				if (direction == 2 && Objects.equals(snakeDir.get(time), "L")) {
					direction = 0;
					continue;
				}
				if (direction == 3 && Objects.equals(snakeDir.get(time), "D")) {
					direction = 0;
					continue;
				}
				if (direction == 3 && Objects.equals(snakeDir.get(time), "L")) {
					direction = 1;
					continue;
				}
			}
		}

		bw.write(time+"");
		bw.flush();
		bw.close();
	}
}