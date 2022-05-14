import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {

	static int N;
	static boolean[] visited;
	static int[] team;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		visited = new boolean[N];
		team = new int[N/2];
		
		arr = new int[N][N];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0,0);
		System.out.println(min);
	}

	// 조합
	private static void comb(int cnt, int start) {
		if(cnt == N/2) {   
			int number = 0;
			int team2[] = new int[N/2];
			int idx = 0, idx2 = 0;
			int startTeam = 0;
			int linkTeam = 0;
			
			while(number < N) {
				if(idx < N/2 && team[idx] == number) {
					idx++; number++;
				}else {
					team2[idx2] = number;
					idx2++; number++;
				}
			}
			
			for(int i = 0; i < team.length-1; i++) {
				for(int j = i+1; j < team.length; j++) {
					startTeam += arr[team[i]][team[j]] + arr[team[j]][team[i]];
				}
			}
			for(int i = 0; i < team2.length-1; i++) {
				for(int j = i+1; j < team2.length; j++) {
					linkTeam += arr[team2[i]][team2[j]] + arr[team2[j]][team2[i]];
				}
			}
			
			min = Math.min(Math.abs(linkTeam-startTeam), min);
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(visited[i]) continue;
			team[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
}
