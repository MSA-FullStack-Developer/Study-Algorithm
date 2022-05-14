import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {

	static class Node{
		int r, c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N;
	static char[][] arr, rgArr;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		// 적록색약이 보는 경우 R,G는 같은것으로 인식
		int cntRG = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(new Node(i,j), 1);
					cntRG++;
				}
			}
		}
		
		int cnt = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(new Node(i,j), 0);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt + " " + cntRG);
	}
	
	public static void bfs(Node start, int rg) {
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c]=true;
		char flag = arr[start.r][start.c];
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					if(rg == 0 && arr[nr][nc] == flag) {
						visited[nr][nc] = true;
						q.add(new Node(nr, nc));
					}
					
					if(rg == 1 && flag != 'B' && arr[nr][nc] != 'B') {
						visited[nr][nc] = true;
						q.add(new Node(nr, nc));
					}else if(rg == 1 && flag == 'B' && arr[nr][nc] == 'B') {
						visited[nr][nc] = true;
						q.add(new Node(nr, nc));
					}
				}
			}
		}
	}

}
