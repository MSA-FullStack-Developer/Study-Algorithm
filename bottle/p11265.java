import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11265 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] party = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 와샬 알고리즘 적용
        for (int k = 1; k <= n; k++) { // 정점 갯수
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (party[i][j] > party[i][k] + party[k][j]) {
                        party[i][j] = party[i][k] + party[k][j];
                    }
                }
            }
        }
        int count = 0;
        while (true) {
            if (count == m) {
                break;
            }
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (party[a][b] <= c) {
                bw.write("Enjoy other party" + "\n");
            } else {
                bw.write("Stay here" + "\n");
            }
            count++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
