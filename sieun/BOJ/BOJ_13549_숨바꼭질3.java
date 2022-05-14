import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * bfs
 */
public class BOJ_13549_숨바꼭질3 {
	
	static class Move{
		int dir, time;

		public Move(int dir, int time) {
			super();
			this.dir = dir;
			this.time = time;
		}
	}
	static int N, K, size;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		size = Math.max(N, K);
		visited = new boolean[1000001];
		bfs();
	}

	private static void bfs() {
		Queue<Move> q = new LinkedList<Move>();
		visited[N] = true;
		q.add(new Move(N, 0));
		
		while(!q.isEmpty()) {
			Move temp = q.poll();
			
			if(temp.time > min) continue;
			if(temp.dir == K) {
				System.out.println(temp.time);
				return;
			}

			if(temp.dir*2 <= 100000 && !visited[temp.dir*2]) {
				visited[temp.dir*2] = true;
				q.add(new Move(temp.dir*2, temp.time));
			}
			
			if(temp.dir-1 >= 0 && !visited[temp.dir-1]) {
				visited[temp.dir-1] = true;
				q.add(new Move(temp.dir-1, temp.time+1));
			}
			
			if(temp.dir+1 <= 100000 && !visited[temp.dir+1]) {
				visited[temp.dir+1] = true;
				q.add(new Move(temp.dir+1, temp.time+1));
			}
			
		}
	}
}
