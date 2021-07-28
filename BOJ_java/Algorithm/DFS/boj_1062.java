import java.util.Scanner;

public class boj_1062 {

    static int N,K;
    static boolean[] visited = new boolean[26];
    static String[] subWord;
    static Scanner sc = new Scanner(System.in);
    private static int max = 0;

    public static void main(String[] args) {
        N= sc.nextInt();
        K=sc.nextInt();
        if (K < 5){
            System.out.println(0);
            return;
        }
        else if (K == 26){
            System.out.println(N);
            return;
        }
        else{
            visited['a'-97] = true;
            visited['n'-97] = true;
            visited['t'-97] = true;
            visited['i'-97] = true;
            visited['c'-97] = true;
            // 기본 a n t i c 방문 쳌
            subWord = new String[N];
            for(int i = 0 ; i < N ; i  ++){
                String word = sc.next();
                subWord[i] = word.substring(4,word.length()-4);
            }
            dfs(0,0);
            System.out.println(max);
        }
    }

    private static void dfs(int index, int start) {
        int count = 0;
        if ( index == K-5){
            for (int i = 0 ; i < N ; i ++){
                boolean pass = true;
                for (int j = 0 ; j < subWord[i].length();j++){
                    if(!visited[subWord[i].charAt(j) - 97]){
                        pass= false;
                        break;
                    }
                }
                if(pass){
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        else{ // 모든 알파벳 조합 재귀 호출
            for ( int i = start ; i < 26 ; i ++){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(index+1,i+1);
                    visited[i] = false;
                }
            }
        }
    }
}
