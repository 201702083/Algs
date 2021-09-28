
import java.util.LinkedList;
import java.util.Queue;
class Leet_03 {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        char[] given = new char[s.length()];
        int answer = 0;
        for ( int i = 0 ; i < s.length() ; i ++){
            given[i] = s.charAt(i);
        }
        int i = 0;
        while(i < s.length()){
            Queue<Character> temp = new LinkedList<>();
            boolean exist = false;
            while(true){
                if ( queue.size() == 0) break;
                char subChar = queue.poll();
                if ( subChar != given[i] ) {
                    temp.add(subChar);

                }
                else {
                    exist = true;
                    break;
                }
            }
            if (! exist ) queue = temp;

            queue.add(given[i]);

            if ( queue.size() > answer ) answer = queue.size();
            i++;
        }
        return answer;
    }
}