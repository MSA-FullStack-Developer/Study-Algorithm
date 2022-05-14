import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 
8 8
01000100
01010100
01010100
01010100
01010100
01010100
01010100
00010100
5 10
0000011000
1101011010
0000000010
1111111110
1111000000
 */
public class BOJ_2206_벽부수고이동하기 {

	static class Node{
		int r, c, score, wall;
		public Node(int r, int c, int score, int wall) {
			this.r = r; 
			this.c = c;
			this.score = score;
			this.wall = wall;
		}
	}
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			char[] chArr = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				arr[i][j] = chArr[j]-'0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		if(N == 1 && M == 1) result = 1;
		if(result == Integer.MAX_VALUE) result = -1;
		System.out.println(result);
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j< M; j++) {
//				System.out.print(visited[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
	
	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,1,0));
		visited[0][0] = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();

			if(node.r == N-1 && node.c == M -1) result = Math.min(result, node.score);
			for(int i = 0; i < 4; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
//				System.out.println(nr + " " + nc + " " + node.wall);
				
				if(nr>=0&&nr<N&&nc>=0&&nc<M) {
					if(visited[nr][nc] > node.wall) { // 방문하지 않은 노드
						if(arr[nr][nc] == 0) {
							q.add(new Node(nr,nc,node.score+1,node.wall));
							visited[nr][nc] = node.wall;
						}else {
							if(node.wall == 0) {
								q.add(new Node(nr,nc,node.score+1,node.wall+1));
								visited[nr][nc] = node.wall + 1;
							}
						}
					}
				}
			}
		}
	}
}
//https://wonit.tistory.com/573
