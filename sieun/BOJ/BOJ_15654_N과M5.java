import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15654_N과M5 {

	static int N, M;
	static int[] arr;
	static int[] numbers;
	static boolean[] visited;
	static List<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		visited = new boolean[N];
		list = new ArrayList<String>();
		
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
			for(int i = 0; i < numbers.length-1; i++) {
				if(numbers[i] > numbers[i+1]) return;
			}
			
			String str = "";
			for(int n : numbers) {
				str += n;
			}
			
			if(!list.contains(str)) {
				list.add(str);
				for(int n : numbers) {
					System.out.print(n+" ");
				}
				System.out.println();
			}
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
