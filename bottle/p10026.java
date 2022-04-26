import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10026 {
    static int n;
    static String[][] check;
    static boolean[][] visited;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        check = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String color = br.readLine();
            for (int j = 0; j < n; j++) {
                check[i][j] = color.substring(j, j + 1);
            }
        }
        String[] kind = { "R", "G", "B" };
        int d = 0;
        int count = 0;
        while (true) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    if (check[a][b].equals(kind[d]) && !visited[a][b]) {
                        dfs(a, b, kind[d]);
                        count++;
                    }
                }
            }
            d++;
            visited = new boolean[n][n];
            if (d == 3) {
                break;
            }
        }

        int count_b = 0;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (check[a][b].equals(kind[2]) && !visited[a][b]) {
                    dfs2(a, b, kind[2]);
                    count_b++;
                }
            }
        }

        int count_rg = 0;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if ((check[a][b].equals(kind[0]) || check[a][b].equals(kind[1])) && !visited[a][b]) {
                    dfs3(a, b, kind[0], kind[1]);
                    count_rg++;
                }
            }
        }

        System.out.print(count);
        System.out.println(" " + (count_b + count_rg));
    }

    public static void dfs(int r, int c, String d) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                if (check[nr][nc].equals(d) && !visited[nr][nc]) {
                    dfs(nr, nc, d);
                }
            }
        }
    }

    public static void dfs2(int r, int c, String d) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                if (check[nr][nc].equals(d) && !visited[nr][nc]) {
                    dfs2(nr, nc, d);
                }
            }
        }
    }

    public static void dfs3(int r, int c, String d1, String d2) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                if ((check[nr][nc].equals(d1) || check[nr][nc].equals(d2)) && !visited[nr][nc]) {
                    dfs3(nr, nc, d1, d2);
                }
            }
        }
    }
}
