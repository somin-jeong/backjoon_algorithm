import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String c : completion) {
            if (map.containsKey(c)) {
                int num = map.get(c);
                map.put(c, num+1);
            } else {
                map.put(c, 1);
            }
        }

        String answer = "";
        for (String p : participant) {
            if (map.containsKey(p)) {
                if (map.get(p) == 1) {
                    map.remove(p);
                } else {
                    int num = map.get(p);
                    map.put(p, num-1);
                }
            } else {
                answer = p;
            }
        }

        return answer;
    }
}