import java.io.*;
import java.util.*;

public class boj_16932 {
    static int R, C, value = 1, max = 1;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        map = new int[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                if (map[i][j] == 1 && !visit[i][j]) {
                    visit[i][j] = true;
                    map[i][j] = value;
                    list.add(dfs(i, j, value++));
                }
            }
        }

        findMax();
//		print();
        System.out.println(max);

    }

    private static int dfs(int x, int y, int value) {
        int t = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (!visit[nx][ny] && map[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    map[nx][ny] = value;
                    t += dfs(nx, ny, value); // 집단의 크기를 구합니다.
                }
            }
        }
        return t;
    }

    private static void findMax() {
        int allSum;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    allSum = calcNum(i, j);
                    max = Math.max(allSum, max);
                }
            }
        }
    }

    private static int calcNum(int x, int y) {
        int allSum = 0;
        HashSet<Integer> hm = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (map[nx][ny] > 0) {
                    hm.add(map[nx][ny] - 1);
                }
            }
        }
        for (int num : hm) {
            allSum += list.get(num);
        }
        return allSum + 1;
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.format("%2d ", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < value - 1; i++) {
            System.out.println((i + 1) + "의 개수 = " + list.get(i) + " 개");
        }
        System.out.println("------------------------");
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }

}