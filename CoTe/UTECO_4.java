import java.util.ArrayList;
import java.util.Collections;

public class UTECO_4 {
    public static void main(String[] args) {
        String s = "aaabbaaa";
        for (int a : solution4(s)) System.out.println(a);
    }
    public static int[] solution4(String s) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        boolean rotate = false;
        int entry = 0;
        for (int i = 0 ; i < s.length()-1 && !rotate; i ++){
            if (s.charAt(i) != s.charAt(i+1)) {entry = i+1 ; rotate = true;}

        }
        int i = entry;
        int n = 0;
        while ( i < s.length() -1 ){
            n++;
            if ( s.charAt(i) == s.charAt(i+1)){
            }else {
                list.add(n);
                n = 0;
            }
            i ++;
        }
        list.add(n+1 + entry);
        Collections.sort(list);
        answer = new int[list.size()];
        for ( int a = 0 ; a < list.size() ; a ++){
            answer[a] = list.get(a);
        }
        return answer;
    }
}
