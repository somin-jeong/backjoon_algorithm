import java.util.ArrayDeque;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        ArrayDeque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!stack.isEmpty() && stack.peek().equals(String.valueOf(c))) {
                stack.pop();
                continue;
            }
            stack.push(String.valueOf(c));
        }

        if (stack.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}