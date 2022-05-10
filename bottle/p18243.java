import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p18243 {

    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] network = new int[n + 1][n + 1];

        // 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    network[i][j] = 0;
                } else {
                    network[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            network[x][y] = network[y][x] = 1;
        }

        System.out.println("---------------------------");
        for (int[] s : network) {
            for (int ss : s) {
                System.out.print(ss + " ");
            }
            System.out.println();
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    if (network[b][c] > network[b][a] + network[a][c]) {
                        network[b][c] = network[b][a] + network[a][c];
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (network[i][j] > 6) {
                    count++;
                }
            }
        }
        System.out.println("---------------------------");
        for (int[] s : network) {
            for (int ss : s) {
                System.out.print(ss + " ");
            }
            System.out.println();
        }

        if (count == 0) {
            System.out.println("Small World!");
        } else {
            System.out.println("Big World!");
        }
    }
}