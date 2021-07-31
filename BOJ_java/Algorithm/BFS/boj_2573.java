
import javax.swing.*;
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
//        System.out.println("Row : " + startRow +"\nCol : " + startCol);

        // 루트는 빙산 크기가 가장 큰 곳

        // 루트를 기준으로 덩어리의 크기를 구한다.
        while ( map[startRow][startCol] > 0){
//            System.out.println("\n\n");
            visit= new boolean[N][M];
            int size = search(startRow,startCol,0);
//            System.out.println(yearCount+"년 빙산의 크기 : "+size);
            yearCount++;
//            for ( int i = 0 ; i < N ; i ++){
//                for ( int j = 0 ; j < M ; j ++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
            int melt_ = melting();
//            System.out.println(yearCount+ "년에 녹은 개수  "+melt_);
            if ( melt_ != 0){
                visit= new boolean[N][M];
                int newsize = search(startRow,startCol,0);
//                System.out.println("녹은 후 : "+newsize);
                if ( (size - melt_) != newsize) {
                    System.out.println(yearCount);
                    return;
                }
            }
        }
        System.out.println(0);
        // 반복문을 돌며 덩어리의 각 원소를 -1 한다.
        // 0이 되는 것이 있다면 다시 덩어리를 순회하고, 0이 된 개수보다 덩어리의 크기가 더 줄었다면 덩어리가 분리된 것


    }

    public static int search(int row, int col, int count){
        visit[row][col] = true;
        count++;
        if (map[row][col] == 0) return 0;
        for ( int i = 0 ; i < 4 ; i ++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if ( 0 <= newRow && newRow < N && 0 <= newCol && newCol < M){
                if ( map[newRow][newCol] == 0){
                    melt[row][col]++;
                }
                else if (! visit[newRow][newCol] ){
                    count = search(newRow,newCol,count);
                }
            }

        }

        return count;
    }
    public static int melting(){
        int count = 0;
        for (int i = 0 ; i < N ; i ++){
            for ( int j = 0 ; j < M ; j ++){
                if ( map[i][j] > 0 ){
                    if ( map[i][j] - melt[i][j] < 1){
                        count++;
                        map[i][j] = 0;
                    } else{
                        map[i][j] -= melt[i][j];
                    }
                }

            }
        }
        melt = new int[N][M];
        return count;
    }

}
