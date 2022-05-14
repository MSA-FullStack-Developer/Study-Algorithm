import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	static int N, S;
	static int[] arr;
	static boolean[] selected;
	static boolean[] visited;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		selected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		System.out.println(result);
	}
	
	private static void subset(int cnt) {
		if(cnt == N) {
			int sum = 0;
			int flag = 0;
			for(int i = 0; i < selected.length; i++) {
				if(selected[i]) {
					flag = 1;
					sum += arr[i];
					System.out.print(arr[i] + " ");
				}
			}
			if(flag != 0 && sum == S) result++;
			System.out.println("===="+sum+"=====");
			return;
		}
			selected[cnt] = true;
			subset(cnt+1);
			selected[cnt] = false;
			subset(cnt+1);
	}

}
