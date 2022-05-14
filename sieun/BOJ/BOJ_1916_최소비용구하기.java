import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {

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
	static int N, M, start ,end;
	static List<Node>[] list;
	static int[] d;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		d = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))); 
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		System.out.println(d[end]);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited[start] = true;
		d[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			visited[node.dest] = true;
			
			if(node.dest == end) break; 
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
