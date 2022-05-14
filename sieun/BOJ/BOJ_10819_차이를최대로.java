import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {
	
	static int N;
	static int[] arr;
	static boolean[] visited;
	static int[] numbers;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0);
		System.out.println(max);
	}
	
	private static void perm(int cnt) {
		if(cnt == N) {
			int sum = 0;
			for(int i = 0; i < numbers.length-1; i++) {
				sum += Math.abs(numbers[i] - numbers[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = arr[i];
			perm(cnt+1);
			visited[i] = false;
		}
	}
}
