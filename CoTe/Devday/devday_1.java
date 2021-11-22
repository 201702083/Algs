import java.util.ArrayList;

public class devday_1 {


    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4 B F F 3 4 B B 3 5 6 B B B"));
    }
    public static int solution(String s) {
        int answer = 0;
        int[] visitN = new int[100];
        ArrayList<Integer> visit = new ArrayList<>();
        ArrayList<Integer> forward = new ArrayList<>();
        String[] pages = s.split(" ");

        for (String page : pages ){
            int check = 0;
            if ( page.equals("B")) {
                if (visit.size() > 1) {
                    check = visit.get(visit.size()-2); // 이전 페이지 check
                    forward.add(visit.get(visit.size()-1)); // 현재 페이지 forward list
                    visit.remove(visit.size()-1);
                }
                // visit 마지막 back 으로 옮김
            } else if ( page.equals("F")){
                if ( !forward.isEmpty()) {
                    check = forward.get(forward.size()-1);
                    visit.add(check);
                    forward.remove(forward.size()-1);
                }
                // back 의 마지막 삭제
            } else {
                check = Integer.parseInt(page);
                visit.add(check);
                forward = new ArrayList<>(); // 맨 앞 페이지
                // visit 추가
            }
            if ( check != 0) visitN[check] ++;
        }
        for ( int i : visitN) if (answer < i ) answer = i;

        return answer;
    }
}

