import java.util.ArrayList;
import java.util.Scanner;

public class boj_23348 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] Level = new int[3];

    static ArrayList<ArrayList<ArrayList<Integer>>> score = new ArrayList<>();
    public static void main(String[] args) {

        for ( int i = 0 ; i < 3 ; i ++) {
            Level[i] = sc.nextInt();
        }
        N = sc.nextInt();

        for ( int i = 0 ; i < N ; i ++ ){
            score.add(new ArrayList<>());
            for ( int j = 0 ; j < 3 ; j ++){
                score.get(i).add(new ArrayList<>());
                for ( int k = 0 ; k < 3 ; k ++){
                    int temp = sc.nextInt();
                    score.get(i).get(j).add(temp);
                }
            }
        }

        // level , temp 입력 완료
        // temp * level 해서 max 값
        int max = 0;
        for ( int i = 0 ; i < N ; i ++ ){
            int sco = 0;
            for ( int j = 0 ; j < 3 ; j ++){
                for ( int k = 0 ; k < 3 ; k ++){
                    sco +=score.get(i).get(j).get(k) * Level[k];
                }
            }
            if ( max < sco ) max = sco;
        }
        System.out.println(max);

    }


}
