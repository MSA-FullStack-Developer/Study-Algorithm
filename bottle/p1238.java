import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1238 {
    static final int INF = 987654321;
    static int n; // 마을
    static int m; // 도로
    static int x; // 타겟
    static List<Node>[] list;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        ArrayList<Integer> answer = new ArrayList<>();
        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        for (int i = 1; i <= n; i++) {
            int go;
            int back;
            dijkstra(i);
            go = dist[x];
            Arrays.fill(dist, INF);
            visited = new boolean[n + 1];
            dijkstra(x);
            back = dist[i];
            answer.add(go + back);
            Arrays.fill(dist, INF);
            visited = new boolean[n + 1];
        }

        Collections.sort(answer);
        System.out.println(answer.get(answer.size() - 1));

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;

            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;

            for (Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
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
