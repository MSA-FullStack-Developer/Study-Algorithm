import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1743 {

    static int n;
    static int m;
    static int[][] check;
    static boolean[][] visited;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int[] arr = new int[100 * 100];
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        check = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = 0;
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            check[x][y] = 1;
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (check[a][b] == 1 && !visited[a][b]) {
                    dfs(a, b);
                    count++;
                }
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 1]);
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        arr[count]++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                if (check[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }

}
