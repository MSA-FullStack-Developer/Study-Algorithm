import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_15663_N과M9 {

	static int N, M;
	static int[] arr;
	static int[] numbers;
	static boolean[] visited;
	static HashSet<String> hash;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		numbers = new int[M];
		visited = new boolean[N];
		hash = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			String str = "";
			for(int i : numbers) {
				str += i + " ";
			}
			// list보다 hashset이 더 빠름
			if(!hash.contains(str)) {
				System.out.println(str);
				hash.add(str);
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				numbers[cnt] = arr[i];
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
}
