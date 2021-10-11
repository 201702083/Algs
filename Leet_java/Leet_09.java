class Leet_09 {
    public static void main(String[] args) {

        System.out.println(isPalindrome(1234));

    }
    public static boolean isPalindrome(int x) {
        if ( x < 0 ) return false;
        String in = Integer.toString(x);
        for ( int i = 0 ; i < in.length() ; i ++){
            if ( in.charAt(i) != in.charAt(in.length() - i - 1 )) return false;
        }
        return true;

    }
}