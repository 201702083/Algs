import java.util.Scanner;

public class boj_1712 {
    static double A;
    static double B;
    static double C;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        A = sc.nextDouble();
        B = sc.nextDouble();
        C = sc.nextDouble();

        if (B>=C) {
            System.out.println(-1);
            return;
        }
        else{
            int k = (int) ((int) A/(C-B));
            System.out.println(k+1);

        }
    }
}
//A + b*n < c*n
// A < (c-b)n
