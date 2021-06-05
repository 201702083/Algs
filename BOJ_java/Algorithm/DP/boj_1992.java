import java.util.Random;
import java.util.Scanner;

public class boj_1992 {
    static Random rand = new Random();
    public static boolean CheckPlot(int[][] list, int size, int row, int col) {
        for (int i = 0; i < size; i++) { // list, 2 , 0 , 0
            for (int j = 0; j < size ; j++) {
                if (list[row][col] != list[row+i][col+j]) // 같은 열 앞뒤가 다르면
                    return false; // 동일하지 않음

            }
        }
        return true;
    }

    // 1. 압축이 불가능하다 -> 4등분 -> Z 순서로 4 등분
    // 2. 압축이 가능하다 -> 출력
    public static void dac(int[][] list, int size, int row, int col) {
        if (size == 1)
            System.out.print(list[row][col]);
        else {
            if (CheckPlot(list, size, row, col))
                System.out.print(list[row][col]);
            else {
                System.out.print("(");

                if (CheckPlot(list, size / 2, row, col)) {
                    System.out.print(list[row][col]);
                } else {
                    dac(list, size / 2, row, col);
                }
                if (CheckPlot(list, size / 2, row, col + size / 2)) {
                    System.out.print(list[row][col + size / 2]);
                } else {
                    dac(list, size / 2, row, col + size / 2);
                }
                if (CheckPlot(list, size / 2, row + size / 2, col)) {
                    System.out.print(list[row + size / 2][col]);
                } else {
                    dac(list, size / 2, row + size / 2, col);
                }
                if (CheckPlot(list, size / 2, row + size / 2, col + size / 2)) {
                    System.out.print(list[row + size / 2][col + size / 2]);
                } else {
                    dac(list, size / 2, row + size / 2, col + size / 2);
                }
                System.out.print(")");

            }

        }

    }

    public static boolean check(int value) {
        for (int i = 0; i < 8; i++) {
            int prv = 1;
            prv = (int) (prv * Math.pow(2, i));
            if (value == prv) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        boolean q = check(a);
        while (!q) {
            System.out.println("! error : 2의 n제곱 값을 입력하시오");
            a = sc.nextInt();
            q = check(a);
        } // 2의 n제곱 값 입력 받기

        int matrix[][] = new int[a][a];
        for (int i = 0; i < a; i++) {
            String line = sc.next();
            String txt[] = line.split("");
            for (int j = 0; j < a; j++)
                matrix[i][j] = Integer.parseInt(txt[j]);
        }


        dac(matrix, a, 0, 0);

    }

}
