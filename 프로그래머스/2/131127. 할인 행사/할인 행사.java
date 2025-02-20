import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {int answer = 0;

        for (int i=0; i<=discount.length-10; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            for (int j=0; j<want.length; j++) {
                map.put(want[j], number[j]);
            }

            for (int j=i; j<10+i; j++) {
                if (map.containsKey(discount[j])) {
                    if (map.get(discount[j]) > 1) {
                        int num = map.get(discount[j]);
                        map.put(discount[j], num-1);
                    } else if (map.get(discount[j]) == 1) {
                        map.remove(discount[j]);
                    }
                } else {
                    break;
                }
            }

            if (map.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}