import java.util.Arrays;
import java.util.Scanner;

public class boj_2399 {
    static int N;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        N = sc.nextInt(); //  0 ~ 10000
        int[] dots = new int[N];
        for ( int i = 0 ; i < N ; i ++) dots[i] = sc.nextInt(); // 0 ~ 1,000,000,000
        //Worst case : 0 x 5000 , 1,000,000,000 x 5000 -> 5 trillion
        Arrays.sort(dots);
        // for 2번으로 돌고 N = 10000개 -> 4byte * 10000 * 10000 , N^2

        long sum = 0 ;
        for ( int i = 0 ; i < N-1 ; i ++){
            for ( int j = i+1 ; j < N ; j ++){
                sum += 2 * (dots[j] - dots[i]);
            }
        }
        System.out.println(sum);
    }
}
