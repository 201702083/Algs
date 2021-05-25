import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1038 {

    public static String findDesc(int n) {
        if(n < 10)
            return String.valueOf(n);

        Queue<String> desc = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            desc.add(String.valueOf(i));

        int idx = 9;
        while(!desc.isEmpty()) {
            String val = desc.poll();
            for (int i = 0; i < (val.charAt(val.length() - 1) - '0'); i++) {
                desc.add(val + i);
                idx++;
                if(idx == n)
                    return val + i;
            }
        }
        return String.valueOf(-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(findDesc(sc.nextInt()));

    }
}
