import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_실버 {

	static int k;
	static int[] arr;
	static int[] numbers;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		
		while(k != 0) {
			arr = new int[k];
			numbers = new int[6];
			visited = new boolean[k];
			for(int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			
			st = new StringTokenizer(br.readLine()); 
			k = Integer.parseInt(st.nextToken());
			System.out.println();
		}
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == 6) {
			for(int i : numbers) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < k; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = arr[i];
			comb(cnt+1, i+1);
			visited[i] = false;
		}
	}

}
