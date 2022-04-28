import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7562 {
    static int l;
    static int[][] check;
    static boolean[][] visited;

    static int[] dr = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int[] dc = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static ArrayList<Integer> list = new ArrayList<>();
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];
            check = new int[l][l];
            arr = new int[l][l];
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            bfs(x1, y1, x2, y2);
            list.add(arr[x2][y2]);
            visited = new boolean[l][l];
        }

        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void bfs(int r, int c, int r2, int c2) {
        if (r == r2 && c == c2) {
            return;
        }
        // 시작 좌표와 도착 좌표가 동일 할때 break

        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        queue.add(c);
        // 현재 좌표를 큐에 넣는다.
        arr[r][c] = 0; // 출발지에서는 카운트 하지 않음

        while (!queue.isEmpty()) {
            r = queue.poll();
            c = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < l && nc < l) {
                    if (!visited[nr][nc]) {
                        arr[nr][nc] = arr[r][c] + 1; // 현재좌표에서 이동 좌표로 갈 때 이동거리 1추가
                        visited[nr][nc] = true; // 이동 좌표는 방문했기 때문에 true로 바꿔준다.
                        queue.add(nr);
                        queue.add(nc);
                        // 이동한 좌표를 큐에 넣는다.
                    }
                }
            }
        }
    }
}
