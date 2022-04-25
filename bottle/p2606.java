import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2606 {
    static int n;
    static int m;
    static int[][] check;
    static boolean[] visited;

    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        check = new int[101][101];
        visited = new boolean[101];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            check[x][y] = check[y][x] = 1;
        }
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int i) {
        visited[i] = true;

        for (int j = 1; j <= n; j++) {
            if (check[i][j] == 1 && visited[j] == false) {
                dfs(j);
                count++;
            }
        }
    }
}
