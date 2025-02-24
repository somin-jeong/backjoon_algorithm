
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parent = new HashMap<>();
        for (int i=0; i<enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        HashMap<String, Integer> finalPrice = new HashMap<>();
        for (int i=0; i<seller.length; i++) {
            String name = seller[i];
            int price = amount[i]*100;

            while (!Objects.equals(name, "-") && !(price < 1)) {
                finalPrice.put(name, finalPrice.getOrDefault(name, 0) + price - (int) (price * 0.1));
                price = (int) (price * 0.1);
                name = parent.get(name);
            }
        }

        ArrayList<Integer> totalPrice = new ArrayList<>();
        for (String e : enroll) {
            totalPrice.add(finalPrice.getOrDefault(e, 0));
            System.out.println(finalPrice.getOrDefault(e, 0));
        }
        
        return totalPrice.stream().mapToInt(Integer::intValue).toArray();
    }
}