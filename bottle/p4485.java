import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class p4485 {

    static final int INF = 987654321;
    static int n; // 동굴의 크기

    static int[][] cave;
    static boolean[][] visited;
    static int[][] dist;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            cave = new int[n][n];
            visited = new boolean[n][n];
            dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            dijkstra(0, 0, cave[0][0]);
            bw.write("Problem " + count + ": " + dist[n - 1][n - 1] + "\n");
            count++;
        }
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int r, int c, int weight) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(new Node(r, c, weight));
        dist[0][0] = cave[0][0];

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            r = curNode.x;
            c = curNode.y;

            if (visited[r][c]) {
                continue;
            }
            visited[r][c] = true;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                    if (dist[nr][nc] > dist[r][c] + cave[nr][nc]) {
                        dist[nr][nc] = dist[r][c] + cave[nr][nc];
                        queue.add(new Node(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
