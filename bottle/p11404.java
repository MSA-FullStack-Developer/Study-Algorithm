import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11404 {

    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] city = new int[n][n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    city[i - 1][j - 1] = 0;
                } else {
                    city[i - 1][j - 1] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if (city[x - 1][y - 1] > z) {
                city[x - 1][y - 1] = z;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (city[i - 1][j - 1] > city[i - 1][k - 1] + city[k - 1][j - 1]) {
                        city[i - 1][j - 1] = city[i - 1][k - 1] + city[k - 1][j - 1];
                    }
                }
            }
        }

        for (int[] s : city) {
            for (int ss : s) {
                if (ss == INF) {
                    ss = 0;
                }
                bw.write(ss + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
