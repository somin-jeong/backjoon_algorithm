import java.util.ArrayDeque;

class Solution {
    public int solution(String[] maps) {
        char[][] mapsInfo = new char[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            mapsInfo[i] = maps[i].toCharArray();
        }

        int start_row = 0;
        int start_col = 0;
        int end_row = 0;
        int end_col = 0;
        int lever_row = 0;
        int lever_col = 0;
        for (int i = 0; i < mapsInfo.length; i++) {
            for (int j = 0; j < mapsInfo[i].length; j++) {
                if (mapsInfo[i][j] == 'S') {
                    start_row = i;
                    start_col = j;
                }

                if (mapsInfo[i][j] == 'L') {
                    lever_row = i;
                    lever_col = j;
                }

                if (mapsInfo[i][j] == 'E') {
                    end_row = i;
                    end_col = j;
                }
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[mapsInfo.length][mapsInfo[0].length];
        queue.add(new int[]{start_row, start_col});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_row = now[0];
            int now_col = now[1];

            if (now_row+1 < mapsInfo.length && distance[now_row+1][now_col] == 0 && mapsInfo[now_row+1][now_col] != 'X') {
                distance[now_row+1][now_col] =  distance[now_row][now_col] + 1;
                queue.add(new int[]{now_row+1, now_col});

                if (mapsInfo[now_row+1][now_col] == 'L') {
                    break;
                }
            }
            if (now_row-1 >= 0 && distance[now_row-1][now_col] == 0 && mapsInfo[now_row-1][now_col] != 'X') {
                distance[now_row-1][now_col] =  distance[now_row][now_col] + 1;
                queue.add(new int[]{now_row-1, now_col});

                if (mapsInfo[now_row-1][now_col] == 'L') {
                    break;
                }
            }
            if (now_col+1 < mapsInfo[now_row].length && distance[now_row][now_col+1] == 0 && mapsInfo[now_row][now_col+1] != 'X') {
                distance[now_row][now_col+1] =  distance[now_row][now_col] + 1;
                queue.add(new int[]{now_row, now_col+1});

                if (mapsInfo[now_row][now_col+1] == 'L') {
                    break;
                }
            }
            if (now_col-1 >= 0 && distance[now_row][now_col-1] == 0 && mapsInfo[now_row][now_col-1] != 'X') {
                distance[now_row][now_col-1] =  distance[now_row][now_col] + 1;
                queue.add(new int[]{now_row, now_col-1});

                if (mapsInfo[now_row][now_col-1] == 'L') {
                    break;
                }
            }
        }
        int lever_distance = distance[lever_row][lever_col];
        if (lever_distance == 0) {
            return  -1;
        }
        queue.clear();
        distance = new int[mapsInfo.length][mapsInfo[0].length];

        queue.add(new int[]{lever_row, lever_col});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_row = now[0];
            int now_col = now[1];

            if (now_row+1 < mapsInfo.length && distance[now_row+1][now_col] == 0 && mapsInfo[now_row+1][now_col] != 'X') {
                distance[now_row+1][now_col] =  distance[now_row][now_col] + 1;
                queue.add(new int[]{now_row+1, now_col});

                if (mapsInfo[now_row+1][now_col] == 'E') {
                    break;
                }
            }
            if (now_row-1 >= 0 && distance[now_row-1][now_col] == 0 && mapsInfo[now_row-1][now_col] != 'X') {
                distance[now_row-1][now_col] =  distance[now_row][now_col] + 1;
                queue.add(new int[]{now_row-1, now_col});

                if (mapsInfo[now_row-1][now_col] == 'E') {
                    break;
                }
            }
            if (now_col+1 < mapsInfo[now_row].length && distance[now_row][now_col+1] == 0 && mapsInfo[now_row][now_col+1] != 'X') {
                distance[now_row][now_col+1] =  distance[now_row][now_col] + 1;
                queue.add(new int[]{now_row, now_col+1});

                if (mapsInfo[now_row][now_col+1] == 'E') {
                    break;
                }
            }
            if (now_col-1 >= 0 && distance[now_row][now_col-1] == 0 && mapsInfo[now_row][now_col-1] != 'X') {
                distance[now_row][now_col-1] =  distance[now_row][now_col] + 1;
                queue.add(new int[]{now_row, now_col-1});

                if (mapsInfo[now_row][now_col-1] == 'E') {
                    break;
                }
            }
        }

        if (distance[end_row][end_col] == 0) {
            return -1;
        }
        int answer = lever_distance + distance[end_row][end_col];
        return answer;
    }
}