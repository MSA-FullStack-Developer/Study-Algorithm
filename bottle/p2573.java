import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2573 {
    static int n;
    static int m;

    static int[][] check;
    static boolean[][] visited;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

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

        int time = 0;
        while (true) {
            // 만약 영역이 모두 0이라면 빙산이 모두 녹을 때 까지 영역이 분리되지 않음
            int ice = 0;
            for (int[] s : check) {
                for (int ss : s) {
                    if (ss == 0) {
                        ice++;
                    }
                }
            }
            if (ice == n * m) {
                System.out.println("0");
                break;
            }
            // 영역 갯수 세기
            int count = 0;
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (check[a][b] != 0 && !visited[a][b]) {
                        dfs_count(a, b);
                        count++;
                    }
                }
            }
            visited = new boolean[n][m];
            if (count >= 2) {
                System.out.println(time);
                break;
            }
            // 인접 바다 확인하여 숫자 바꾸기
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (check[a][b] != 0 && !visited[a][b]) {
                        dfs(a, b);
                    }
                }
            }
            // 시간 증가
            time++;
            visited = new boolean[n][m];
        }
    }

    // 빙산 주변에 0의 갯수를 파악하고 빙산을 녹인다.
    // 하지만 이미 빙산이 녹아서 0으로 된 빙산이 주변 빙산에 영향을 주면 안되기 때문에
    // 기존 빙산의 위치는 true로 바꾼다.
    public static void dfs(int r, int c) {

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                if (check[nr][nc] == 0 && !visited[nr][nc]) {
                    if (check[r][c] != 0)
                        check[r][c] = check[r][c] - 1;

                    visited[r][c] = true;
                }
            }
        }
    }

    public static void dfs_count(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                if (check[nr][nc] != 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs_count(nr, nc);
                }
            }
        }
    }
}