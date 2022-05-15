import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {

	static class Node{
		int r, c;
		int count;
		public Node(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
		int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
		for(int i = 0; i < T; i++) {
			int l = Integer.parseInt(br.readLine());
			int[][] arr = new int[l][l];
			boolean[][] visited = new boolean[l][l];
			
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int n3 = Integer.parseInt(st.nextToken());
			int n4 = Integer.parseInt(st.nextToken());
			Queue<Node> q = new LinkedList<>(); 
			q.add(new Node(n1, n2, 0));
			visited[n1][n2] = true;
			
			while(!q.isEmpty()) {
				Node n = q.poll();
				if(n.r == n3 && n.c == n4) {
					System.out.println(n.count);
					break;
				}
				
				for(int j = 0;j < 8; j++) {
					int nr = n.r + dr[j];
					int nc = n.c + dc[j];
					if(nr >= 0 && nr < l && nc >= 0 && nc < l && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Node(nr, nc, n.count+1));
					}
				}
			}
		}
	}

}
