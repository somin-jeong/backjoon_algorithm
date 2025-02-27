import java.util.ArrayDeque;
import java.util.StringTokenizer;
class Solution {
    public int solution(int[][] maps) {
        int[][] distance = new int[maps.length][maps[0].length];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        int row = 0;
        int col = 0;

        queue.add(new int[]{row, col});
        distance[row][col] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowRow = poll[0];
            int nowCol = poll[1];

            if (nowRow-1 >= 0 && maps[nowRow-1][nowCol] == 1 && distance[nowRow-1][nowCol] == 0) {
                queue.add(new int[]{nowRow-1, nowCol});
                distance[nowRow-1][nowCol] = distance[nowRow][nowCol] + 1;
            }
            if (nowCol-1 >= 0 && maps[nowRow][nowCol-1] == 1 && distance[nowRow][nowCol-1] == 0) {
                queue.add(new int[]{nowRow, nowCol-1});
                distance[nowRow][nowCol-1] = distance[nowRow][nowCol] + 1;
            }
            if (nowRow+1 < maps.length && maps[nowRow+1][nowCol] == 1 && distance[nowRow+1][nowCol] == 0) {
                queue.add(new int[]{nowRow+1, nowCol});
                distance[nowRow+1][nowCol] = distance[nowRow][nowCol] + 1;
            }
            if (nowCol+1 < maps[0].length && maps[nowRow][nowCol+1] == 1 && distance[nowRow][nowCol+1] == 0) {
                queue.add(new int[]{nowRow, nowCol+1});
                distance[nowRow][nowCol+1] = distance[nowRow][nowCol] + 1;
            }
        }

        if (distance[maps.length-1][maps[0].length-1] != 0) {
            return distance[maps.length-1][maps[0].length-1];
        }

        return -1;
    }
}