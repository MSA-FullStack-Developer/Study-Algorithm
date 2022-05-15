import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972_택배배송 {

	static class Node implements Comparable<Node>{
		int dest, weight;
		public Node(int dest ,int weight) {
			this.dest = dest;
			this.weight = weight;
		}
		
		public int compareTo(Node node) {
			return this.weight - node.weight;
		}
	}
	
	static int N, M;
	static boolean[] visited;
	static int[] d;
	static List<Node>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		d = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i< N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		dijkstra(1);
		System.out.println(d[N]);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(!visited[node.dest]) {
				visited[node.dest] = true;
				for(Node n : list[node.dest]) {
					if(d[n.dest] >= d[node.dest] + n.weight) {
						d[n.dest] = d[node.dest] + n.weight;
						pq.add(new Node(n.dest, d[n.dest]));
					}
				}
			}
		}
	}

}
