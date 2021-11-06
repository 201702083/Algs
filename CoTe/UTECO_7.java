public class UTECO_7 {
    public static void main(String[] args) {
        String[] grid = {"I", "DID", "CODTE", "BAEMINS", "GOODEXPER"};
        for ( String line : solution7(grid, false)) {
            System.out.println(line);
        }
    }
    public static String[] solution7(String[] grid, boolean clockwise) {
        String[] answer = new String[grid.length];
        int row = grid.length -1;

        if (clockwise) { // root -> row,0
            for ( int i = row ; i >= 0 ; i -- ){
                String line = "";
                int _c = 2 * (row - i);
                for ( int j = 0 ; j < row - i ; j ++){
                    line = (line + grid[row-j].charAt(_c))+grid[row-j].charAt(_c-1);
                    System.out.print(grid[row-j].charAt(_c)+ " " +grid[row-j].charAt(_c-1)+ " ");
                    _c -= 2;
                }
                System.out.println(grid[i].charAt(0));
                line += grid[i].charAt(0);
                answer[row - i] = line;
            }
        }else { // root -> row, col
            for ( int i = row; i >= 0 ; i -- ){
                String line = "";
                int _r = i;
                int _c = 2 * i;
                line+= grid[_r].charAt(_c);
                for ( int j = _r + 1 ; j <= row ; j ++) {
                    for ( int k = _c+1; k >= _c  ; k --){
                        line+=grid[j].charAt(k);
                    }
                }
                answer[row - i] = line;
            }
        }
        return answer;
    }

}
