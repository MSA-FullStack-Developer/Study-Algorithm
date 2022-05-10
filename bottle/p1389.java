import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1389 {

    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] check = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) { // 자기 자신을 제외한 모든 공간 무한대로 초기화
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    check[i][j] = 0;
                } else {
                    check[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            check[x][y] = check[y][x] = 1;
        }

        for (int k = 1; k <= n; k++) { // 최단 경로 알고리즘 수행
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (check[i][j] > check[i][k] + check[k][j]) {
                        check[i][j] = check[i][k] + check[k][j];
                    }
                }
            }
        }

        int res = INF;
        int idx = -1;

        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                total += check[i][j];
            }
            // System.out.println(total);
            if (res > total) {
                res = total;
                idx = i;
            }
            // total = 0;
        }

        System.out.println(idx);
        // for (int[] is : check) {
        // for (int is2 : is) {
        // System.out.print(is2 + " ");
        // }
        // System.out.println();
        // }
    }
}
