import java.util.Scanner;

public class boj_4963 {
    static int w, h;
    static int[][] map;
    static boolean[][] visit;
    static Scanner sc = new Scanner(System.in);

    private static int answer(int x, int y) {
        int[] dx = {0,0,1,-1,-1,1,-1,1}, dy = {1,-1,0,0,-1,1,1,-1};

        visit[x][y] = true;
        for (int i = 0 ; i < 8 ; i++) {
            int moveX = x+dx[i], moveY = y+dy[i];
            if (moveX>=0 & moveY >=0 & moveX < h & moveY < w){
                if (!visit[moveX][moveY] & map[moveX][moveY] == 1) answer(moveX,moveY);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        w = sc.nextInt();
        h = sc.nextInt();
        while (w != 0 | h != 0) {
            int sum = 0;
            map = new int[h][w];
            visit = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if ( map[i][j] == 1 & !visit[i][j]) sum += answer(i,j);

                }
            }
            System.out.println(sum);
            w = sc.nextInt();
            h = sc.nextInt();
        }
    }


}
