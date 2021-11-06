public class UTECO_5 {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 4;
        for ( int[] line : solution5(rows, columns)){
            System.out.println();
            for ( int cell : line){
                System.out.print(cell + " ");
            }
        }
    }
    public static int[][] solution5(int rows, int columns) {
        int[][] answer = new int[rows][columns];
        int end = rows * columns;
        int count = 1;
        if ( rows == columns ) {
            end = (rows * 2) -1;
            count = 0;
        }
        int r = 0;
        int c = 0;
        answer[r][c] = 1;
        int record = 1;
        while ( count<end ){
            if ( record % 2  == 0) r++;
            else c++;
            if ( c > columns - 1) c = c % columns;
            if ( r > rows - 1) r = r%rows;
            record++;
            if (answer[r][c] == 0) count ++ ;
            answer[r][c] = record;
        }

        return answer;
    }
}
