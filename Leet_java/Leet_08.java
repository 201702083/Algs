class Leet_08 {
    public static void main(String[] args) {

        System.out.println(myAtoi("ㅋㅋ"));
        System.out.println(myAtoi("123332 test case"));
        System.out.println(myAtoi("test 13333333333333333333"));
        System.out.println(myAtoi("2147483649"));
    }
    public static int myAtoi(String s) {
        s = s.trim(); // Step 1 . 공백 제거
        final int MAX_LENGTH = 10;
        boolean start = false;
        boolean neg = false;
        int idx = 0;
        // field 선언

        if ( s.length() == 0) return 0; // "" 처리

        if ( s.charAt(0) == '-') {
            idx ++;
            neg = true;
        }
        else if ( s.charAt(0) == '+') idx ++;
        // Step 2 . - , + 처리

        while(!start){
            if (idx == s.length()) break;
            if (s.charAt(idx) != '0') {
                start = true;
                break;
            }
            idx ++;
        }
        if ( !start ) return 0;
        // Step 3 . 맨 앞 0 들 제거

        String clear = "";
        while(true){
            if (idx == s.length()) break;
            if ( Character.isDigit(s.charAt(idx)) ) clear+=s.charAt(idx);
            else break;
            idx++;
        }
        if (clear.length() == 0) return 0;
        // Step 4 . 문자가 들어올 때까지의 숫자 구별

        if ( clear.length() > MAX_LENGTH) {
            if ( neg ) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        else if (clear.length() < MAX_LENGTH) {
            if (neg) return Integer.parseInt(clear) * -1;
            else return Integer.parseInt(clear);
        }
        // overflow 구별 전 자릿수 밖은 바로 처리

        idx = 0;
        String compare;
        if (neg) {
            compare = Integer.toString(Integer.MIN_VALUE);
            compare = compare.substring(1,compare.length());
        }
        else compare = Integer.toString(Integer.MAX_VALUE);
        // overflow 구분을 위한 idx 와 compare 초기화

        boolean inBound = true; // 범위 내
        while(idx < MAX_LENGTH){
            if (compare.charAt(idx)-'0' > clear.charAt(idx)-'0') { // 하나라도 작으면 true end
                inBound = true;
                break;
            }
            else if ( compare.charAt(idx)-'0' < clear.charAt(idx)-'0') { // 하나라도 크면 false end
                inBound = false;
                break;
            }
            idx ++;
        } // Step 5 . Int 오버플로우 판단

        if (inBound) { // 범위 내에 있으면 부호를 붙여 Integer로 반환
            if(!neg){
                return Integer.parseInt(clear);
            } else {
                return Integer.parseInt("-"+clear);
            }
        }
        else { // 범위 밖이면 MIN,MAX Value 를 반환
            if ( neg ) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
    }
}