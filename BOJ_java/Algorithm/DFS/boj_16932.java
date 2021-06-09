import java.util.Scanner;

public class boj_16932 {
    static int h,w;
    static int[][] map;
    static boolean[][] visit;
    static Scanner sc = new Scanner(System.in);
    static int count = 0;
    static int dfs(int x, int y){
        int[] dx = {0,0,1,-1} ,dy = {1,-1,0,0};
        count++;
        visit[x][y] = true;
        for ( int i  = 0 ; i < 4 ; i ++){
            int moveX = x+dx[i], moveY = y+dy[i];
            if (moveX >=0 & moveY >=0 & moveX <h & moveY <w){
                if (map[moveX][moveY] == 1 & !visit[moveX][moveY]) {
                    dfs(moveX,moveY);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        h = sc.nextInt();
        w = sc.nextInt();
        map = new int[h][w];
        visit = new boolean[h][w];
        int max = 0;
        for ( int i = 0 ; i < h ; i ++){
            for ( int j = 0 ; j < w ; j ++) {
                map[i][j] = sc.nextInt();
            }
        }
        for ( int i = 0 ; i < h ; i ++){
            for ( int j = 0 ; j < w ; j ++){
                if ( map[i][j] == 0 ){
                    int dfsAns = dfs(i, j);
                    count = 0;
                    if (max < dfsAns) {
                        max = dfsAns;
                    }
                    visit = new boolean[h][w];

                }
            }
        }
        System.out.println(max);

    }
}
