import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {
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
	static int N, M, u, v;
	static List<Node>[] list;
	static int[] d;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		d = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			list[n1].add(new Node(n2,n3)); 
			list[n2].add(new Node(n1,n3)); 
		}
		
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		int res1 = 0;
		int res2 = 0;
		
		for(Node n : list[u]) {
			if(n.dest == v) {
				res1 = n.weight;
				res2 = n.weight;
			}
		}
		
		dijkstra(1);
		int a1 = d[u];
		int a2 = d[v];
		
		d = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		dijkstra(N);
		int b1 = d[v];
		int b2 = d[u];

		if(res1 != 0 && a1 != Integer.MAX_VALUE && b1 != Integer.MAX_VALUE) {
			res1 = a1 + b1;
		}else if(res2 != 0 && a2 != Integer.MAX_VALUE && b2 != Integer.MAX_VALUE){
			res2 = a2 + b2;
		}else {
			System.out.println("-1");
			return;
		}
		if(res1 != 0 && res2 != 0)
			System.out.println(Math.min(res1, res2));
		else if(res1 == 0 && res2 != 0)
			System.out.println(res2);
		else
			System.out.println(res1);
	}
	
	static int min = Integer.MAX_VALUE;
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		d[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			visited[node.dest] = true;
			
			for(Node n : list[node.dest]) {
				if(!visited[n.dest]) {
					if(d[n.dest] >= d[node.dest] + n.weight) {
						d[n.dest] = d[node.dest] + n.weight;
						pq.add(new Node(n.dest, d[n.dest]));
					}
				}
			}
		}
	}

}
