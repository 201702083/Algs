
import java.util.Scanner;

public class boj_2573 {
    static int N,M;
    static Scanner sc = new Scanner(System.in);
    static boolean[][] visit;
    static int[][] map;
    static int[][] melt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        melt = new int[N][M];
        visit = new boolean[N][M];
        int yearCount = 0;
        int startRow = 0;
        int startCol = 0;
        int max = 0;
        for ( int i = 0 ; i < N  ;  i ++ ){
            for ( int j = 0 ; j < M ; j ++){
                map[i][j] = sc.nextInt();
                if  (map[i][j] > max){
                    max = map[i][j];
                    startRow = i;
                    startCol = j;
                }
            }
        }
        solution();
//        System.out.println("Row : " + startRow +"\nCol : " + startCol);


    }

    private static void solution() {
        int year = 0;

        while(true){
            int count = 0;
            for(int i = 0 ; i < N ; i ++){
                for (int j = 0 ; j < M ; j ++){
                    if ( map[i][j] != 0 && !visit[i][j]){
                        search(i,j);
                        count++;
                    }
                }
            }
            if (count == 0){
                System.out.println(0);
                return;
            }
            if (count > 1 ){
                System.out.println(year);
                return;
            }
            melting();
            year++;
        }

    }

    public static void search(int row, int col){
        visit[row][col] = true;
        for ( int i = 0 ; i < 4 ; i ++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if ( 0 <= newRow && newRow < N && 0 <= newCol && newCol < M){
                if ( map[newRow][newCol] == 0){
                    melt[row][col]++;
                }
                if (!visit[newRow][newCol] && map[newRow][newCol] != 0 ){
                    search(newRow,newCol);
                }
            }

        }
    }
    public static void melting(){
        for (int i = 0 ; i < N ; i ++){
            for ( int j = 0 ; j < M ; j ++){
                if ( map[i][j] > 0 ){
                    if ( map[i][j] - melt[i][j] < 1){
                        map[i][j] = 0;
                    } else{
                        map[i][j] -= melt[i][j];
                    }
                    melt[i][j] = 0;
                    visit[i][j] = false;
                }

            }
        }
    }

}
