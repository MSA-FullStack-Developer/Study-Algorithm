import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p4963 {
    static int n;
    static int m;
    static int[][] check;
    static boolean[][] visited;

    static int[] dr = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static int[] dc = { 1, 1, 1, 0, 0, -1, -1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            check = new int[m][n];
            visited = new boolean[m][n];

            if (n == 0 && m == 0) {
                break;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    check[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    if (check[a][b] == 1 && !visited[a][b]) {
                        dfs(a, b);
                        count++;
                    }
                }
            }
            list.add(count);
        }
        for (Integer ll : list) {
            System.out.println(ll);
        }
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        for (int a = 0; a < 8; a++) {
            int nr = r + dr[a];
            int nc = c + dc[a];

            if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                if (check[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }
}
