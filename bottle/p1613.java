import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1613 {
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] history = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                history[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            history[x][y] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (history[i][j] > history[i][k] + history[k][j]) {
                        history[i][j] = history[i][k] + history[k][j];
                    }
                }
            }
        }
        System.out.println();
        for (int[] s : history) {
            for (int ss : s) {
                System.out.print(ss + " ");
            }
            System.out.println();
        }
        System.out.println();
        // st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            if (history[first][last] == INF && history[last][first] == INF) {
                bw.write("0" + "\n");
            } else if (history[first][last] != INF && history[last][first] == INF) {
                bw.write("-1" + "\n");
            } else if (history[first][last] == INF && history[last][first] != INF) {
                bw.write("1" + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
