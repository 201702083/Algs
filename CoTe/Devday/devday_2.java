public class devday_2 {
    public static void main(String[] args) {
        int[][] queries = {{3,2},{2,2},{2,2},{2,2},{1,1}};
        int[][] answer = solution(3,4,2,queries);
        for (int[] rows : answer){
            for (int col : rows) System.out.print(col + " ");
            System.out.println();
        }
    }

    static int row,column;
    static int[][] answer;
    static int max;
    static int[] dX = {0,0,-1,1};
    static int[] dY = {-1,1,0,0};
    static boolean[][] visit;
    public static int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        answer = new int[rows][columns];
        row = rows;
        column = columns;
        max = max_virus;

        for ( int[] query : queries ){
            visit = new boolean[row][column];
            세균증식(query[0]-1,query[1]-1);
        }
        return answer;
    }
    static void 세균증식(int y, int x){

        visit[y][x] = true;
        if ( answer[y][x] < max) {
            answer[y][x]++; // max보다 작으면 +1
        }
        else { // max보다 크면 상하좌우 세균 증식
            for (int i = 0 ;i < 4 ; i ++){
                int newY = y + dY[i];
                int newX = x + dX[i] ;
                if ( newY >=0 && newY < row && newX >=0 && newX < column) {
                    if (!visit[newY][newX]) {
                        세균증식(newY,newX);
                    }

                }
            }
        }

    }
}
