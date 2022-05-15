import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회 {

	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr =new int[N][N];
		visited = new boolean[N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			loop(i, i, 0, 0);
		}
		System.out.println(min);
	}

	private static void loop(int start, int cur, int sum, int cnt) {
		if(cnt == N-1) {
			if(arr[cur][start] != 0) {
				sum += arr[cur][start];
				min = Math.min(sum, min);
			}
			return;
		}
		for(int i = 0; i < N; i++) {
			if(arr[cur][i] != 0 && !visited[i]) {
				visited[i] = true;
				loop(start, i, sum+arr[cur][i], cnt+1);
				visited[i] = false;
			}
		}
	}
}
