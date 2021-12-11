import java.util.ArrayList;
import java.util.Scanner;

public class boj_1450 {

    static int n;
    static int c;
    static int[] items;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> listA = new ArrayList<>();
    static ArrayList<Integer> listB = new ArrayList<>();
    public static void main(String[] args) {
        n = sc.nextInt();
        c = sc.nextInt();
        items = new int[n];
        int idx = 0;
        int result = 0;
        for (int i = 0 ; i < n ; i ++) items[i] = sc.nextInt();
        // Input

        findA(0, 0);
        findB(n/2, 0);
        listB.sort((i,j) -> (i-j));
        // Get list A and B , Sort listB -> use 2-pt at listB

        for ( int i = 0 ; i < listA.size() ; i ++){
            idx = -1;
            int l = 0;
            int r = listB.size()-1;
            // Set 2 pointers
            int value = listA.get(i);
            while (l <= r) {
                int mid = (l + r) / 2;
                if (listB.get(mid) + value <= c) { // 적재 가능
                    idx = mid;
                    l = mid + 1;
                } else { // 불가
                    r = mid - 1;
                }
            }
            result += idx + 1;
        }
        System.out.println(result);
    }

    static void findA(int i, int sum) {
        if ( sum > c ) return ;
        if ( i == n/2){
            listA.add(sum);
            return;
        }
        findA(i+1, sum);
        findA(i+1, sum + items[i]);
    }
    static void findB(int i, int sum) {
        if ( sum > c ) return ;
        if ( i == n){
            listB.add(sum);
            return;
        }
        findB(i+1, sum);
        findB(i+1, sum + items[i]);

    }
}
