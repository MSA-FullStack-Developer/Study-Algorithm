import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352_특정거리도시찾기 {

	static class Node implements Comparable<Node>{
		int dest, weight;
		
		public Node(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
		
		public int compareTo(Node node) {
			return this.weight - node.weight;
		}
	}
	static int N, M, K, X;
	static List<Integer>[] list;
	static boolean[] visited;
	static int[] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		d = new int[N+1];
		
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		dijkstra(X);
		int cnt = 0;
		for(int i = 1; i < N+1; i++) {
			if(d[i] == K) {
				System.out.println(i);
				cnt++;
			}
		}
		if(cnt == 0) System.out.println("-1");
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(!visited[n.dest]) {
				visited[n.dest] = true;
				for(int i : list[n.dest]) {
					if(d[i] >= d[n.dest] + 1) {
						d[i] = d[n.dest] + 1;
						pq.add(new Node(i, d[i]));
					}
				}
			}
		}
	}
}
