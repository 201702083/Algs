class Leet_04 {
    public static void main(String[] args) {
        String input = "aaaabaaa";
        System.out.println(longestPalindrome(input));
    }
    public static String longestPalindrome(String s) {
        char[] substr = new char[s.length()];
        int strIdx = 0;
        int max = 0; // 부분문자열 최대 길이
        int idx_begin = 0;
        int idx_end = 0;
        while (true){ // 주어진 문자열 끝까지
            if (strIdx == s.length()) break;
            substr[strIdx] = s.charAt(strIdx);

            // 투 포인터를 가지고 양 끝을 비교한다. 틀릴 시 앞 포인터를 +1
            int front = 0;
            int back = strIdx;
            int diff = 0;
            int start = 0; // Palindromic Substring 의 시작 인덱스
            while(true){
                if ( front == back || front - back == 1) break;
                // 모두 탐색한 경우
                if (substr[front] == substr[back]) { // 하나씩 비교하여 같으면 가운데로
                    front ++;
                    back --;
                } else { // 다르면 front를 diff +1 로 보내고 back 은 다시 맨 뒤로 보낸다.
                    diff ++;
                    front = diff;
                    start = front;
                    back = strIdx;
                }
            }
            if ( strIdx - start > max) {
                max = strIdx - start;
                idx_begin = start;
                idx_end = strIdx;
            }
            strIdx ++;
        }
        String answer = "";
        for ( int i = idx_begin ; i <= idx_end ; i ++) answer += substr[i];
        return answer;
    }
}