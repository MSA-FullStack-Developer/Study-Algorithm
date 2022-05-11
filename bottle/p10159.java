import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p10159 {

    static final int INF = 9;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] product = new int[n + 1][n + 1];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                product[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            product[x][y] = 1;
        }

        // System.out.println();
        // for (int[] s : product) {
        // for (int ss : s) {
        // System.out.print(ss + " ");
        // }
        // System.out.println();
        // }
        // System.out.println("-----------플로이드 와샬 이전--------------");

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (product[i][j] > product[i][k] + product[k][j]) {
                        product[i][j] = product[i][k] + product[k][j];
                    }
                }
            }
        }

        // System.out.println();
        // for (int[] s : product) {
        // for (int ss : s) {
        // System.out.print(ss + " ");
        // }
        // System.out.println();
        // }
        // System.out.println("-----------플로이드 와샬 이후--------------");

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    if (product[i][j] == INF && product[j][i] == INF) {
                        count++;
                    }
                }
            }
            list.add(count);
            count = 0;
        }
        for (int s : list) {
            System.out.println(s);
        }
    }
}
