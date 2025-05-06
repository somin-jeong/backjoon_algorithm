import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] kingPos = new int[2];
	static int[] rockPos = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		String king = st.nextToken();
		String rock = st.nextToken();
		char[] kingCharPos = king.toCharArray();

		kingPos[0] = getIntPosition(kingCharPos[0]);
		kingPos[1] = Integer.parseInt(String.valueOf(kingCharPos[1]));

		char[] rockCharPos = rock.toCharArray();
		rockPos[0] = getIntPosition(rockCharPos[0]);
		rockPos[1] = Integer.parseInt(String.valueOf(rockCharPos[1]));

		int count = Integer.parseInt(st.nextToken());

		for (int i = 0; i < count; i++) {
			String move = br.readLine();
			move(move);
		}

		String kingCol = getCharPosition(kingPos[0]);
		int kingRow = kingPos[1];

		String rockCol = getCharPosition(rockPos[0]);
		int rockRow = rockPos[1];

		bw.write(kingCol+kingRow+"\n");
		bw.write(rockCol+rockRow+"\n");
		bw.flush();
		bw.close();
	}

	public static int getIntPosition(char pos) {
		switch (pos) {
			case 'A' : return 1;
			case 'B' : return 2;
			case 'C' : return 3;
			case 'D' : return 4;
			case 'E' : return 5;
			case 'F' : return 6;
			case 'G' : return 7;
			case 'H' : return 8;
			default : return -1;
		}
	}

	public static String getCharPosition(int pos) {
		switch (pos) {
			case 1 : return "A";
			case 2 : return "B";
			case 3 : return "C";
			case 4 : return "D";
			case 5 : return "E";
			case 6 : return "F";
			case 7 : return "G";
			case 8 : return "H";
			default : return "";
		}
	}

	public static void move(String direction) {
		int dx = 0, dy = 0;

		switch (direction) {
			case "R" : dx = 1; break;
			case "L" : dx = -1; break;
			case "B" : dy = -1; break;
			case "T" : dy = 1; break;
			case "RT" : { dx = 1; dy = 1; break;}
			case "LT" : { dx = -1; dy = 1; break;}
			case "RB" : { dx = 1; dy = -1; break;}
			case "LB" : { dx = -1; dy = -1; break;}
		}

		int nextKingX = kingPos[0] + dx;
		int nextKingY = kingPos[1] + dy;

		// 왕이 움직일 수 있는지 확인
		if (nextKingX < 1 || nextKingX > 8 || nextKingY < 1 || nextKingY > 8) return;

		// 돌과 같은 위치로 이동하려는 경우
		if (nextKingX == rockPos[0] && nextKingY == rockPos[1]) {
			int nextRockX = rockPos[0] + dx;
			int nextRockY = rockPos[1] + dy;

			// 돌이 체스판을 벗어나면 이동 무시
			if (nextRockX < 1 || nextRockX > 8 || nextRockY < 1 || nextRockY > 8) return;

			rockPos[0] = nextRockX;
			rockPos[1] = nextRockY;
		}

		kingPos[0] = nextKingX;
		kingPos[1] = nextKingY;
	}
}