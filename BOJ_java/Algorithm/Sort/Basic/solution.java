import java.util.ArrayList;
import java.util.Scanner;

public class solution {
    static long min = 3000000000L; // 세 용액의 최대 합 3,000,000,000
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> sol = new ArrayList<>();

        for (int i = 0 ; i < n ; i ++) {
            sol.add(i,sc.nextLong());
        }

        for ( int i = sol.size() -1 ; i > 0 ; i -- ){
            for ( int j = 0 ; j < i ; j ++ ){
                if ( sol.get(j) > sol.get(j+1) ){
                    long temp = sol.get(j);
                    sol.set(j,sol.get(j+1));
                    sol.set(j+1,temp);
                }
            }
        } // 입력받은 용액들의 특성 값을 오름차순으로 정렬

        int x=0,y=0,z=0 ; // 결과 값의 좌표들

        for ( int i = 0 ; i < sol.size() - 2;  i ++){
            int s = i+1, e = sol.size()-1,s_=0,e_=0;
            long min_ = 3000000000L;
            while( s < e ) {
                if (min_ > Math.abs(sol.get(i) + sol.get(s) + sol.get(e))) {
                    min_ = Math.abs(sol.get(i) + sol.get(s) + sol.get(e));
                    s_ = s;
                    e_ = e;
                }

                if (sol.get(i) + sol.get(s) + sol.get(e) > 0) {
                    e--;
                } else if (sol.get(i) + sol.get(s) + sol.get(e) < 0) {
                    s++;
                } else {
                    s_ = s;
                    e_ = e;
                    break;
                }
            }
            long sum = Math.abs(sol.get(i) + sol.get(s_) + sol.get(e_));
            if ( min > sum){
                min = sum;
                x = i;
                y = s_;
                z = e_;
            }
        }

        System.out.println(sol.get(x) + " "+ sol.get(y) + " "+ sol.get(z));


    }
}
