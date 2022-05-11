import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p2660 {
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] student = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    student[i][j] = 0;
                } else {
                    student[i][j] = INF;
                }
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == -1 && y == -1) {
                break;
            }
            student[x][y] = student[y][x] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (student[i][j] > student[i][k] + student[k][j]) {
                        student[i][j] = student[i][k] + student[k][j];
                    }
                }
            }
        }

        // for (int[] s : student) {
        // for (int ss : s) {
        // System.out.print(ss + " ");
        // }
        // System.out.println();
        // }

        int[] ranking = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int rank = 0;
            for (int j = 1; j <= n; j++) {
                if (student[i][j] > rank) {
                    rank = student[i][j];
                }
            }
            ranking[i] = rank;
            rank = 0;
        }

        int min = 987654320;
        for (int i = 1; i < ranking.length; i++) {
            if (min > ranking[i]) {
                min = ranking[i];
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < ranking.length; i++) {
            if (ranking[i] == min) {
                list.add(i);
            }
        }
        // bw.write(list.toString() + "\n");
        Collections.sort(list);
        bw.write(min + " " + list.size() + "\n");
        for (int s : list) {
            bw.write(s + " ");
        }
        bw.flush();
        bw.close();
    }
}
