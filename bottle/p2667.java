import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class p2667 {

    static int n;
    static int[][] check;
    static boolean[][] visited;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int count = 0;
    static int[] arr = new int[25 * 25];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        check = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String k = br.readLine();

            for (int j = 0; j < n; j++) {
                check[i][j] = Integer.parseInt((k.substring(j, j + 1)));
            }
        }
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (check[a][b] == 1 && !visited[a][b]) {
                    dfs(a, b);
                    count++;
                }
            }
        }
        System.out.println(count);
        Arrays.sort(arr);
        for (int i : arr) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        arr[count]++;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                if (check[nr][nc] == 1 & !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }

}
