import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p1956 {

    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] road = new int[v + 1][v + 1];

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                road[i][j] = INF;
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            road[a][b] = c;
        }

        // for (int[] s : road) {
        // for (int ss : s) {
        // System.out.print(ss + " ");
        // }
        // System.out.println();
        // }
        // System.out.println("------------플로이드 와샬 이전 배열------------");

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (road[i][j] > road[i][k] + road[k][j]) {
                        road[i][j] = road[i][k] + road[k][j];
                    }
                }
            }
        }

        // for (int[] s : road) {
        // for (int ss : s) {
        // System.out.print(ss + " ");
        // }
        // System.out.println();
        // }
        // System.out.println("------------플로이드 와샬 이후 배열------------");

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) {
                    if (road[i][j] != INF) {
                        list.add(road[i][j]);
                    }
                }
            }
        }

        Collections.sort(list);
        if (!list.isEmpty()) {
            System.out.println(list.get(0));
        } else {
            System.out.println("-1");
        }

    }
}
