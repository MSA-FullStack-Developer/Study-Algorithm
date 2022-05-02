import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p11060 {
    static int n;
    static int[] arr;
    static int[] visited = new int[1001];
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bfs(0);
        if (count == 0) {
            System.out.println("-1");
        }
    }

    public static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = 1;

        while (!queue.isEmpty()) {
            r = queue.poll();
            if (r == n - 1) {
                System.out.println(visited[r] - 1);
                count++;
            }

            if (arr[r] != 0) {
                for (int i = 1; i <= arr[r]; i++) {
                    if (r + i <= n && visited[r + i] == 0) {
                        visited[r + i] = visited[r] + 1;
                        queue.add(r + i);
                    }
                }
            }
        }

    }
}
