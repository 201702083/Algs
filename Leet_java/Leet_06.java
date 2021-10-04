class Leet_06 {
    public static void main(String[] args) {
        String input = "aaaabaaa";
        System.out.println(convert(input, 3));
    }
    public static String convert(String s, int numRows) {
        if ( numRows == 1) return s;
        int idx = 0;
        int _row = 0;
        boolean up = false;
        String line[] = new String[numRows];
        for (int k = 0 ; k < numRows ; k ++) line[k] = "";
        while(true){
            if ( idx == s.length() ) break;
            if ( _row == 0 ) up = false;

            if (up){
                for ( int i = 0 ; i < numRows ; i ++){
                    if ( _row != i ) line[i] += " ";
                    else line[i] += s.charAt(idx);
                }
            } else line[_row] += s.charAt(idx);

            if (_row == numRows-1) up = true;

            if (up) _row --;
            else _row++;
            idx++;

        }
        String answer = "";
        for (int j = 0 ; j < numRows ;j ++) {
            answer += line[j].replaceAll(" ","");
        }
        return answer;
    }
}