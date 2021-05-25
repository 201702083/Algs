import java.util.Scanner;

public class boj_1074 {
    static int N = 0 , r = 0 , c = 0, count = 0;
    static  boolean find = false;
    static void searchOrder(int y, int x ,int n){
        if ( y == r && x == c){ // 1x1 크기 탐색
            System.out.println(count);
            System.exit(0);
        }
        if (y <= r && r < (y + n) && x <= c && c < (x + n)) { // 주어진 박스 안에 있다면 탐색
            searchOrder( y, x , n/2);
            searchOrder( y, x + n/2 , n/2);
            searchOrder( y + n/2, x , n/2);
            searchOrder( y + n/2, x + n/2 , n/2);
        } else // 없다면 현재 박스의 크기를 더해준다.
            count += n * n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        searchOrder(0,0,(int) Math.pow(2,N));
    }
}
