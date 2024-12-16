import java.util.ArrayDeque;
class Solution {
    private final ArrayDeque<String> deque1 = new ArrayDeque<>();
    private final ArrayDeque<String> deque2 = new ArrayDeque<>();

    public int solution(String s) {
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            deque1.add(String.valueOf(c));
        }

        int answer = 0;
        for (int i = 0; i < deque1.size(); i++) {
            if (isCorrectString()) {
                answer++;
            }
            deque1.add(deque1.removeFirst());
        }

        return answer;
    }

    private boolean isCorrectString() {
        for (String string : deque1) {
            if (string.equals("(") || string.equals("{") || string.equals("[")) {
                deque2.push(string);
            } else {
                if (deque2.isEmpty()) {
                    return false;
                }

                if (string.equals(")") && deque2.getFirst().equals("(")) {
                    deque2.pop();
                } else if (string.equals("}") && deque2.getFirst().equals("{")) {
                    deque2.pop();
                } else if (string.equals("]") && deque2.getFirst().equals("[")) {
                    deque2.pop();
                } else {
                    return false;
                }
            }
        }
        return deque2.isEmpty();
    }
}