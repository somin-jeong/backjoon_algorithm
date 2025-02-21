
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();

        for (String s : record) {
            if (s.split(" ")[0].equals("Enter")) {
                map.put(s.split(" ")[1], s.split(" ")[2]);
            } else if(s.split(" ")[0].equals("Change")) {
                map.put(s.split(" ")[1], s.split(" ")[2]);
            }
        }

        List<String> list = new ArrayList<>();
        for (String s : record) {
            if (s.split(" ")[0].equals("Enter")) {
                String name = map.get(s.split(" ")[1]);
                list.add(name + "님이 들어왔습니다.");
            } else if(s.split(" ")[0].equals("Leave")) {
                String name = map.get(s.split(" ")[1]);
                list.add(name + "님이 나갔습니다.");
            }
        }

        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
}