class Leet_07 {
    public static void main(String[] args) {
        System.out.println(reverse(-31231232));
    }
    public static int reverse(int x) {
        if ( x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;
        int answer = 0;
        boolean neg = false;
        if ( x < 0 ) {neg = true; x *= -1;}
        int y = x;
        int digit = 0;
        while(y > 0){
            y /= 10;
            digit ++;
        }
        for ( int i = 1 ; i <= digit ; i ++){
            int digit_n = (int) Math.pow(10,(digit-i));
            int n = Integer.toString(x).charAt(digit-i) - '0';
            if ( n > 0 ){
                if (digit_n > Integer.MAX_VALUE / n  ) return 0;
            }

            if ( answer > Integer.MAX_VALUE -digit_n * n ) return 0;

            answer += digit_n * n;

        }
        if (! neg ) return answer ;
        else return -1 * answer;

    }
}