import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576 {
    static int n;
    static int m;

    static int[][] check;
    static boolean[][] visited;
    static int[][] arr;

    static Queue<Integer> queue = new LinkedList<>();

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new int[m][n];
        visited = new boolean[m][n];
        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                check[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int[] s : check) {
            for (int ss : s) {
                if (ss == 0) {
                    answer++;
                }
            }
        }

        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                if (check[a][b] == 1 && !visited[a][b]) {
                    queue.add(a);
                    queue.add(b);
                }
            }
        }
        bfs();
        int count = 0;
        for (int[] s : check) {
            for (int ss : s) {
                if (ss == 0) {
                    count++;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int[] s : arr) {
            for (int ss : s) {
                list.add(ss);
            }
        }
        Collections.sort(list);
        if (answer == 0) {
            System.out.println("0");
        } else {
            if (count != 0) {
                System.out.println("-1");
            } else {
                System.out.println(list.get(list.size() - 1));
            }
        }
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    if (check[nr][nc] == 0 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        arr[nr][nc] = arr[r][c] + 1;
                        check[nr][nc] = 1;
                        queue.add(nr);
                        queue.add(nc);
                    }
                }
            }
        }
    }
}
