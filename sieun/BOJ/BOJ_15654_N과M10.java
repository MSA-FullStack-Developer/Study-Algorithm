import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N과M10 {

	static int N, M;
	static int[] arr;
	static int[] numbers;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0);
	}
	private static void perm(int cnt) {
		if(cnt == M) {
			for(int n : numbers) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			numbers[cnt] = arr[i];
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
		}
	}
}
