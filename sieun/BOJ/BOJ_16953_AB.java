import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_AB {

	static int A, B;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		bfs(A, 1);
		if(result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	private static void bfs(long num, int cnt) {
		if(num == B) {
			result = Math.min(result, cnt);
			return;
		}
		
		if(num*2 <= B) bfs(num*2, cnt+1);
		if(num*10+1<=B) bfs(num*10+1, cnt+1);
	}
}
