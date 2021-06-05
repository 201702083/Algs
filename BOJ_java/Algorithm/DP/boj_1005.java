import java.util.ArrayList;
import java.util.Scanner;

public class boj_1005 {
    static int T; // 테스트 횟수
    static int F; // 목표 건물
    static int N; // 총 건물 개수
    static int K; // 규칙 개수
    static int[] build; // 건설 비용
    static ArrayList<Integer>[] condition; // 규칙들을 담을 리스트
    static int[] dp; // dp 테이블

    public static int dpAns(int f) {
        int max = -1;
        if (condition[f].isEmpty()) {
            dp[f] = build[f];
        } else {
            for (Integer i : condition[f]) {
                if (dp[i] == -1) dp[i] = dpAns(i);
                max = Math.max(max, dp[i]);
            }
            dp[f] = max + build[f];
        }
        return dp[f];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            build = new int[N + 1];
            condition = new ArrayList[N + 1];
            dp = new int[N + 1];
            for (int i = 0; i < N + 1; i++) { // 초기화
                condition[i] = new ArrayList<>();
                dp[i] = -1;
            }
            dp[0] = 0; // 1번 건물부터 시작
            for (int i = 0; i < N; i++) {
                int a = sc.nextInt();
                build[i + 1] = a;
            }
            for (int i = 0; i < K; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                condition[b].add(a);
            }
            F = sc.nextInt();
            // 조건 , 가격 , 목표 건물 입력
            System.out.println(dpAns(F)); // 정답
        }


    }

}
