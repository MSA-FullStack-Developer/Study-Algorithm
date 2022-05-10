import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11403 {
    static int n;
    static int[][] check;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        check = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                check[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < n; k++) { // k는 거쳐서 가는 노드를 의미함
            for (int i = 0; i < n; i++) { // i에서j로 갈 수 있는가?
                for (int j = 0; j < n; j++) {
                    if (check[i][k] == 1 && check[k][j] == 1) { // i에서 j를 갈 때 거쳐서 가는 길이 있는지 확인함
                        check[i][j] = 1; // i에서 j로 가는 길이 있으면 1
                    }
                }
            }
        }

        for (int[] s : check) {
            for (int ss : s) {
                System.out.print(ss + " ");
            }
            System.out.println();
        }
    }
}