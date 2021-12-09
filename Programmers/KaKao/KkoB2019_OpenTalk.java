import java.util.HashMap;
import java.util.Map;

public class KkoB2019_OpenTalk {
    public static void main(String[] args) {
        String[] testCase = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = solution(testCase);
        for ( String res : result ) System.out.println(res);
    }
    public static String[] solution(String[] record) {
        int n = 0; // result size
        Map<String,String> list = new HashMap<String,String>(); // id - nickname
        for (String str : record){
            String[] splt = str.split(" ");
            if (!splt[0].equals("Change")) n ++ ; // check only enter,leave
            if (!splt[0].equals("Leave")) list.put(splt[1],splt[2]);
        }
        String[] answer = new String[n];
        int idx = 0; // answer index

        for ( String str : record ){
            String[] splt = str.split(" ");
            if (!splt[0].equals("Change")) {
                if ( splt[0].equals("Enter")) answer[idx] = list.get(splt[1]) + "님이" + " 들어왔습니다.";
                else answer[idx] = list.get(splt[1]) + "님이" + " 나갔습니다.";
                idx++;

            }
        }
        return answer;
    }

}




class Solution {

}