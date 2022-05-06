import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14716 {
    static int n;
    static int m;

    static int[][] check;
    static boolean[][] visited;

    static int[] dr = { 1, -1, 0, 0, 1, 1, -1, -1 };
    static int[] dc = { 0, 0, 1, -1, 1, -1, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                check[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (check[a][b] == 1 && !visited[a][b]) {
                    dfs(a, b);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                if (check[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs(nr, nc);
                }
            }
        }
    }
}
