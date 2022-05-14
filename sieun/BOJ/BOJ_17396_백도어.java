import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17396_백도어 {

	static class Node implements Comparable<Node>{
		int dest;
		long weight;
		public Node(int dest, long d) {
			this.dest = dest;
			this.weight = d;
		}
		public int compareTo(Node node) {
			return (int) (this.weight - node.weight);
		}
	}
	static int N, M;
	static int[] arr;
	static long[] d;
	static List<Node>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		visited = new boolean[N];
		d = new long[N];
		arr = new int[N];
		list = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			list[n1].add(new Node(n2,n3));
			list[n2].add(new Node(n1,n3));
		}
		
		dijkstra();
		if(!visited[N-1]) {
			System.out.println("-1");
		}else {
			System.out.println(d[N-1]);
		}
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(d, Long.MAX_VALUE);
		pq.add(new Node(0,0));
		d[0] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(!visited[node.dest]) {
				visited[node.dest] = true;
				for(Node n : list[node.dest]) {
					if(d[n.dest] >= d[node.dest] + n.weight && (arr[n.dest] == 0 || n.dest == N-1)) {
						d[n.dest] = d[node.dest] + n.weight;
						pq.add(new Node(n.dest, d[n.dest]));
					}
				}
			}
		}
	}

}
