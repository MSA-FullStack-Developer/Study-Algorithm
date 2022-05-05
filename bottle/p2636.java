import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2636 {
    static int n;
    static int m;

    static int[][] check;
    static boolean[][] visited;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static ArrayList<Integer> list = new ArrayList<>();
    static int[][] arr;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new int[n][m];
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                check[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int c = 0;
        while (true) {
            for (int[] s : check) {
                for (int ss : s) {
                    if (ss == 1) {
                        c++;
                    }
                }
            }
            bfs(0, 0);
            if (c == 0) {
                break;
            }
            list.add(c);
            c = 0;
            visited = new boolean[n][m];
        }
        System.out.println(list.size());
        if (list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            System.out.println(list.get(list.size() - 1));
        }
    }

    public static void bfs(int r, int c) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(r);
        queue.add(c);

        while (!queue.isEmpty()) {
            r = queue.poll();
            c = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (check[nr][nc] == 1 && !visited[nr][nc]) {
                        check[nr][nc] = 0;
                        visited[nr][nc] = true;
                    }
                    if (check[nr][nc] == 0 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(nr);
                        queue.add(nc);
                    }
                }
            }
        }
    }
}
