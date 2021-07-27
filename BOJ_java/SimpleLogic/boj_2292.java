import java.util.Scanner;

public class boj_2292 {
    static double n;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        n = sc.nextDouble() - 1;
        System.out.println(solution(n));
    }
    private static int solution(double n) {
        double k= 1;
        int count = 2;
        if ( n == 0) return 1;
        while ( k < (n/6)){
            k+=count;
            count++;
        }
        return count;
    }
}

/*
* 0 -> 1칸
* 6*0 <= n <= 6*1 -> 2칸
* 6*1 < n <= 6*3 -> 3칸
* 6*3 < n <= 6*6 -> 4칸
*
*
*
*
* 1 -> 2
* 3 -> 3
* 6 -> 4
* 10 -> 5
*
 */





