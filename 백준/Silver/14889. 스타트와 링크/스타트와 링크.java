import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int count;
	public static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		count = Integer.parseInt(br.readLine());

		int[][] array = new int[count][count];

		for (int i = 0; i < count; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			for (int j = 0; j < count; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] team = new boolean[count];
		Arrays.fill(team, false);
		team[0] = true;
		backtracking(0, 1, team, array);

		bw.write(minDiff+"");
		bw.flush();
		bw.close();
	}

	public static void backtracking(int depth, int idx, boolean[] team, int[][] array) {
		if (depth == count/2-1) {
			int start = 0;
			int link = 0;
			for (int i = 0; i < count; i++) {
				for (int j = i+1; j < count; j++) {
					if (team[i] && team[j]) {
						start += array[i][j] + array[j][i];
					} else if (!team[i] && !team[j]) {
						link += array[i][j] + array[j][i];
					}
				}
			}
			minDiff = Math.min(minDiff, Math.abs(start - link));
			return;
		}

		for (int i = idx; i < count; i++) {
			team[i] = true;
			backtracking(depth+1, i+1, team, array);
			team[i] = false;
		}
	}
}