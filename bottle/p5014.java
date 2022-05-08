import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5014 {
    static int F;
    static int start;
    static int end;
    static int up;
    static int down;
    static int[] arr;
    static int[] visited = new int[1000001];
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        arr = new int[F + 1];
        visited = new int[F + 1];
        for (int i = 0; i < F; i++) {
            arr[i] = i + 1;
        }

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());

        bfs(start);
        if (count == 0) {
            bw.write("use the stairs" + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = 1;
        while (!queue.isEmpty()) {
            r = queue.poll();
            // System.out.print(r + " ");

            if (r == end) {
                System.out.println(visited[r] - 1);
                count++;
            }

            for (int i = 0; i < 2; i++) {

                if (r + up <= F && visited[r + up] == 0) {
                    visited[r + up] = visited[r] + 1;
                    queue.add(r + up);
                }
                if (r - down > 0 && visited[r - down] == 0) {
                    visited[r - down] = visited[r] + 1;
                    queue.add(r - down);
                }

            }
        }
    }
}
