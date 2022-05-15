import java.util.Scanner;

public class BOJ_2579_계단오르기 {

	/* BFS 시간초과 */
	static int n;
	static int[] arr;
//	static int max = Integer.MIN_VALUE;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		n = sc.nextInt();
//		arr = new int[n+1];
//		
//		for(int i = 1; i < n+1; i++) {
//			arr[i] = sc.nextInt();
//		}
//		
//		bfs(0, 0, 0);
//		System.out.println(max);
//	}
//
//	private static void bfs(int cnt, int step, int score) {
//		if(cnt == n) {
//			max = Math.max(max, score);
//			return;
//		}
//		
//		// 한칸 올라가기
//		if(step < 2) {
//			bfs(cnt+1, step+1, score+arr[cnt+1]);
//		}
//		
//		// 두칸 올라가기
//		if(cnt+2 < n+1) {
//			bfs(cnt+2, 1, score+arr[cnt+2]);
//		}
//	}
	
	/* DP */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n+1];
		
		for(int i = 1; i < n+1; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[n+1];
		if(n <= 1) dp[1] = arr[1];
		else {dp[1] = arr[1]; dp[2] = arr[1] + arr[2];}
		for(int i = 3; i < n+1; i++) {
			dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
		}
		
		System.out.println(dp[n]);
	}
}
