import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class kakao_friends_coloring_book {

    static int m = 6;
    static int n = 4;
    static int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 },
            { 0, 0, 0, 1 }, { 0, 0, 0, 3 }, { 0, 0, 0, 3 } };

    static int[][] check;
    static boolean[][] visited;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static int[] arr = new int[100 * 100];
    static int count = 0;

    public static void main(String[] args) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        check = new int[m][n];
        visited = new boolean[m][n];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check[i][j] = picture[i][j];
                if (!list.contains(check[i][j])) {
                    list.add(check[i][j]);
                }
            }
        }

        Collections.sort(list);
        if (list.size() == 1 && list.get(0) == 0) {
            System.out.println(1 + " " + m * n);
        } else {
            int t = 1;
            while (true) {
                for (int a = 0; a < m; a++) {
                    for (int b = 0; b < n; b++) {
                        if (check[a][b] == list.get(t) && !visited[a][b]) {
                            dfs(a, b, list.get(t));
                            count++;
                        }
                    }
                }

                t++;
                visited = new boolean[m][n];
                if (t >= list.size()) {
                    break;
                }
            }
            Arrays.sort(arr);
            System.out.println(count + " " + arr[arr.length - 1]);
        }

    }

    public static void dfs(int r, int c, int t) {
        visited[r][c] = true;
        arr[count]++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                if (check[nr][nc] == t && !visited[nr][nc]) {
                    dfs(nr, nc, t);
                }
            }
        }
    }
}
