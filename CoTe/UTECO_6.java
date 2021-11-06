public class UTECO_6 {
    public static void main(String[] args) {
        double time = 3.5;
        String[][] plans = { {"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"} };
        System.out.println(solution6(time, plans));
    }
    public static String solution6(double time, String[][] plans) {
        String answer = "";
        double rest = time;
        double happyTime = 18;
        double sadTime = 13;

        int i = 0;
        for (String[] plan : plans){
            String startTime = plan[1];
            String endTime = plan[2];
            double start = 0;
            double end = 0;
            if (startTime.substring(startTime.length()-2, startTime.length()).equals("PM")) start+=12;
            start += Double.parseDouble(startTime.substring(0,startTime.length()-2));
            if (endTime.substring(endTime.length()-2, endTime.length()).equals("PM")) end += 12;
            end += Double.parseDouble(endTime.substring(0,endTime.length()-2));

            // 여행지 출발 시각, 도착 시각 계산
            if ( happyTime > start) rest -= (happyTime-start);
            if ( sadTime < end ) rest -= (end - sadTime);

            if ( rest == 0) {
                answer = plan[0];
            } else if ( rest < 0 ) answer = plans[i-1][0];
            i++;
        }
        if ( answer.equals("") ) answer = plans[plans.length - 1][0]; // 모든 여행지를 갈 수 있는 경우 마지막 여행지를 저장


        return answer;
    }
}
