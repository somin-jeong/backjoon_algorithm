class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        for (int i=0; i<n/2; n++) {
            a = (a+1)/2;
            b = (b+1)/2;
            if (a == b) {
                break;
            }
            answer++;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
}