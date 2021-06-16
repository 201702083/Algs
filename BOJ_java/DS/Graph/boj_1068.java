import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class boj_1068 {
    static int n,d;
    static int cnt = 0;
    static ArrayList<Integer>[] tree = new ArrayList[51];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        n = sc.nextInt();

        for ( int i = 0 ; i < 51 ; i ++) tree[i] = new ArrayList<>();

        // Wait input 노드 개수, 각각 부모 노드, 지울 곳 입력
//        for ( int i = 0 ; i < n ; i ++ ){
//            int in = sc.nextInt();
//            if (in != -1){
//                tree[in].add(i);
//            }
//        }
//        d = sc.nextInt();
//        disconnect(d);
//        if ( d == 0) System.out.println(0);
//        else {
//            search(0);
//            System.out.println(cnt);
//        }

        //testcase 노드 개수만 입력하면 트리, 지울 노드 자동 생성
        Random rand = new Random();
        int test_d = rand.nextInt(n);

        for ( int i = 1 ;i < n ; i ++){
            int in = rand.nextInt(i+1);
            System.out.print(in + " ");
            while(in == i) {in = rand.nextInt(i+1);}
            tree[in].add(i);
        }
        System.out.println("\n"+test_d);
        System.out.println("\n-----------Before--------");
        show(0);
        System.out.println("\n-------------------------");

        System.out.println("\n[!] disconnect at "+test_d);
        disconnect(test_d);
        System.out.println("\n-----------After---------");

        show(0);
        System.out.println("\n-------------------------");

        System.out.println();
        if ( test_d == 0) System.out.println(0);
        else {
            search(0);
            System.out.println(cnt);
        }



    }
    public static void show(int i){
        System.out.println("\n--- "+i+" ---");
        if(tree[i].size()==0) System.out.print(" LEAF NODE");
        else for(int a : tree[i]) System.out.print(a +" ");
        for(int a : tree[i]) show(a);
    }
    public static void search(int index) {
        if(tree[index].size()==0) {
            cnt++;
            return;
        }
        for(int i=0; i<tree[index].size(); i++) {
            int next = tree[index].get(i);
            if(tree[index].size()==1 && next==d) {
                cnt++;
                return;
            }
            if(next < n && next != d)
                search(next);
        }
    }

    private static void disconnect(int d) {
        for ( int i = 0 ; i < 51 ; i ++){
            for ( int j = 0 ; j < tree[i].size() ; j ++){
                if (tree[i].get(j) == d) {
                    tree[i].remove(j);
                }
            }
        }
    }
}
