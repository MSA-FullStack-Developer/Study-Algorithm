import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

import java.util.Queue;
import java.util.StringTokenizer;

public class p13549 {

    static int n;
    static int k;

    static int[] visited = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);
    }

    public static void bfs(int r) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r);
        visited[r] = 1;

        while (!queue.isEmpty()) {
            r = queue.poll();

            if (r == k) {
                System.out.println(visited[r] - 1);
                break;
            }
            if (r * 2 <= 100000 && visited[r * 2] == 0) {
                visited[r * 2] = visited[r];
                queue.offer(r * 2);
            }
            if (r - 1 >= 0 && visited[r - 1] == 0) {
                visited[r - 1] = visited[r] + 1;
                queue.offer(r - 1);
            }
            if (r + 1 <= 100000 && visited[r + 1] == 0) {
                visited[r + 1] = visited[r] + 1;
                queue.offer(r + 1);
            }
        }

    }
}
