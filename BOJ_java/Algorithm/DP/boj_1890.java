import java.util.Scanner;

public class boj_1890 {
    static int N;
    static int[][] map;
    static long[][] dp;
    static Scanner sc = new Scanner(System.in);

    static long ans(int x, int y){ // 도달 가능한 모든 경우의 수
        if ( x == N-1 && y == N-1 ) return 1; // 도착시 + 1
        if ( x > N-1 || y > N-1 || map[x][y] == 0) return 0; // 범위 밖 or 칸에 0이면 0 리턴
        if (dp[x][y] != -1) return dp[x][y];
        long res = ans(x+map[x][y],y) + ans(x,y+map[x][y]);
        dp[x][y] = res;
        return res;
    }
    public static void main(String[] args) {
        N = sc.nextInt();
        map = new int[N][N];
        dp = new long[N][N];

        for (int i = 0 ; i < N ; i ++){
            for (int j = 0 ; j < N ; j ++){
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        dp[N-1][N-1] = 0;
        System.out.println(ans(0,0));


    }
}
