import java.util.Scanner;

public class BOJ_10974_모든순열 {

	static int N;
	static int[] numbers;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		visited = new boolean[N+1];
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt == N) {
			for(int i : numbers) {
				System.out.print(i+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				numbers[cnt] = i;
				visited[i] = true;
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
}
