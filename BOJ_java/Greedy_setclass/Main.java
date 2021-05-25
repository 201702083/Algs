import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int time[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			time[i][0] = sc.nextInt(); // start
			time[i][1] = sc.nextInt(); // end
		}
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}

		});

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();

		for (int i = 0; i < N; i++) {
			int end = time[i][1];
			if (!q.isEmpty() && q.peek() <= time[i][0])
				q.poll();
			q.offer(end);
		}
		System.out.println(q.size());

	}

}
