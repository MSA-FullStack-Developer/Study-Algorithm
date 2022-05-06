import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3184 {

    static int n;
    static int m;

    static String[][] check;
    static boolean[][] visited;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int sheep = 0;
    static int wolf = 0;
    static int[] answer = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new String[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                check[i][j] = s.substring(j, j + 1);
            }
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (!check[a][b].equals("#") && !visited[a][b]) {

                    dfs(a, b);
                    // System.out.println();
                    if (sheep <= wolf) {
                        answer[1] = answer[1] + wolf;
                    } else {
                        answer[0] = answer[0] + sheep;
                    }
                    sheep = 0;
                    wolf = 0;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static void dfs(int r, int c) {
        if (check[r][c].equals("o")) {
            sheep++;
        }
        if (check[r][c].equals("v")) {
            wolf++;
        }
        visited[r][c] = true;
        // System.out.print(check[r][c] + " ");

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                if (!check[nr][nc].equals("#") && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs(nr, nc);
                }
            }
        }
    }
}
