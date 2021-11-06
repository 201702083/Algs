public class UTECO_1 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,2,3};
        int[] answer = solution1(arr);
        for ( int r : answer ) System.out.println(r);

    }
    public static int[] solution1(int[] arr) {
        int[] answer = new int[3];
        int one = 0;
        int two = 0;
        int three = 0;
        for ( int a : arr ){
            if ( a == 1 ) one ++;
            else if ( a == 2) two ++;
            else three ++;
        }
        int max = 0;
        if ( one > two && one > three ) max = one;
        else if ( two > one && two > three) max = two;
        else max = three;
        answer[0] = max - one;
        answer[1] = max - two;
        answer[2] = max - three;

        return answer;
    }
}
