import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class p1987 {
    static int n;
    static int m;
    static int[][] check;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();

    static int depth = 0;
    static int answer = 0;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new int[n][m];
        visited = new boolean[n * m];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                String ss = s[j];
                check[i][j] = ss.charAt(0) - 'A';
            }
        }
        dfs(0, 0, depth);
        System.out.println(answer);
    }

    public static void dfs(int r, int c, int depth) {
        if (visited[check[r][c]]) {
            answer = Math.max(answer, depth);
            return;
        } else {
            visited[check[r][c]] = true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    dfs(nr, nc, depth + 1);
                }
            }
            visited[check[r][c]] = false;
        }
    }
}