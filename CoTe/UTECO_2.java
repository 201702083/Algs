public class UTECO_2 {
    public static void main(String[] args) {
        String[] log ={"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
        System.out.println(solution2(log));
    }
    public static String solution2(String[] log) {
        String answer = "";
        String start = "";
        String end = "";
        int allTime = 0;
        for (String time : log){
            if ( start == ""){ // start time
                start = time;
            }
            else { // end time
                end = time;
                int hours = Integer.parseInt(end.split(":")[0]) - Integer.parseInt(start.split(":")[0]);
                int minutes = Integer.parseInt(end.split(":")[1]) - Integer.parseInt(start.split(":")[1]);
                if ( minutes < 0) {minutes *= -1; hours--;}
                int allMin = hours * 60 + minutes;
                if ( allMin >= 5) {
                    if ( allMin > 105 ) allTime += 105;
                    else allTime+=allMin;
                }
                start = "";
            }
        }
        int hours = allTime / 60;
        int minutes = allTime % 60;
        if ( hours < 10) answer += "0"+Integer.toString(hours);
        else answer+=Integer.toString(hours);
        answer+=":";
        if (minutes < 10) answer+="0" + Integer.toString(minutes);
        else answer+=Integer.toString(minutes);
        return answer;
    }
}
