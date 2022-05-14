import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {

	static class Node implements Comparable<Node>{
		int r, c, cnt;
		
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		public int compareTo(Node node) {
			return this.cnt - node.cnt;
		}
	}
	static int N, M;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visited;
	static char[][] arr;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[M][N];
		
		for(int i = 0; i < M; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		visited = new boolean[M][N];
		bfs();
		System.out.println(min);
	}
	
	private static void bfs() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0,0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.r == M-1 && node.c == N-1) {
				min = Math.min(min, node.cnt);
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				
				if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc]) {
					if(!(nr == M-1 && nc == N-1)) visited[nr][nc] = true;
					
					if(arr[nr][nc] == '1') {
						q.add(new Node(nr, nc, node.cnt+1));
					}else {
						q.add(new Node(nr, nc, node.cnt));
					}
				}
			}
		}
	}

}
