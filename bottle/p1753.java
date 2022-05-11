import java.io.*;
import java.util.*;

public class p1753 {

    static final int INF = 987654321;
    static int v;
    static int e;
    static int k;
    static List<Node>[] list;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new ArrayList[v + 1];
        check = new int[v + 1];

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(check, INF);

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        dijkstra(k);

        for (int i = 1; i <= v; i++) {
            if (check[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(check[i]);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[v + 1];

        queue.add(new Node(start, 0));
        check[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;
            // for (int i : check) {
            // System.out.print(i + " ");
            // }
            // System.out.println();
            if (visited[cur] == true)
                continue;
            visited[cur] = true;

            for (Node node : list[cur]) {
                if (check[node.end] > check[cur] + node.weight) {
                    check[node.end] = check[cur] + node.weight;
                    queue.add(new Node(node.end, check[node.end]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
