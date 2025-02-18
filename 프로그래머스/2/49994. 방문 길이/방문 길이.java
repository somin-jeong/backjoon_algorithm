import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        HashMap<String, int[]> map = new HashMap<>();
        map.put("U", new int[]{0, 1});
        map.put("D", new int[]{0, -1});
        map.put("R", new int[]{1, 0});
        map.put("L", new int[]{-1, 0});

        HashSet<String> set = new HashSet<>();

        int x = 0;
        int y = 0;
        char[] array = dirs.toCharArray();
        for (char c : array) {
            int newX = x + map.get(String.valueOf(c))[0];
            int newY = y + map.get(String.valueOf(c))[1];

            if (newX < -5 || newX > 5 || newY > 5 || newY < -5) {
                continue;
            }

            set.add(x + " " + y + " " + newX + " " + newY);
            set.add(newX + " " + newY + " " + x + " " + y);
            x = newX;
            y = newY;
        }

        int answer = set.size()/2;
        return answer;
    }
}