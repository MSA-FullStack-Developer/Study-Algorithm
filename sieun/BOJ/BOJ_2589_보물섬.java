import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {

	static class Node{
		int r, c, t;
		public Node(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	static int N, M;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int max = Integer.MIN_VALUE;
	static Node startNode, endNode;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 'L') {
					visited = new boolean[N][M];
					bfs(new Node(i,j,0));
				}
			}
		}
		visited = new boolean[N][M];
		mstBfs(startNode);
	}
	
	private static void bfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.t > max) {
				startNode = start;
				endNode = n;
				max = n.t;
			}
			for(int i = 0; i< 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr>=0 && nr<N && nc >=0 && nc<M && !visited[nr][nc] && arr[nr][nc]=='L') {
					visited[nr][nc] = true;
					q.add(new Node(nr,nc,n.t+1));
				}
			}
			
		}
	}
	private static void mstBfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.r == endNode.r && n.c == endNode.c) {
				System.out.println(n.t);
				return;
			}
			for(int i = 0; i< 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr>=0 && nr<N && nc >=0 && nc<M && !visited[nr][nc] && arr[nr][nc]=='L') {
					visited[nr][nc] = true;
					q.add(new Node(nr,nc,n.t+1));
				}
			}
			
		}
	}
}
