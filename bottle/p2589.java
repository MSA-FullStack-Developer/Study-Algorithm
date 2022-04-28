import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2589 {
    static int n;
    static int m;
    static String[][] check;
    static boolean[][] visited;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static ArrayList<Integer> list = new ArrayList<>();
    static int[][] arr;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new String[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                check[i][j] = s.substring(j, j + 1);
            }
        }

        arr = new int[n][m];
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (check[a][b].equals("L") && !visited[a][b]) {
                    bfs(a, b);
                    reset(arr);
                }

            }
        }
        Collections.sort(answer);
        System.out.println(answer.get(answer.size() - 1) - 1);

    }

    public static void reset(int[][] arr) {
        for (int[] s : arr) {
            for (int ss : s) {
                if (ss != 0) {
                    list.add(ss);
                }
            }
        }
        Collections.sort(list);
        answer.add(list.get(list.size() - 1));
        list.clear();
        visited = new boolean[n][m];

    }

    public static void bfs(int r, int c) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        queue.add(c);

        arr[r][c] = 1;
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            r = queue.poll();
            c = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (check[nr][nc].equals("L") && !visited[nr][nc]) {
                        arr[nr][nc] = arr[r][c] + 1;
                        visited[nr][nc] = true;
                        queue.add(nr);
                        queue.add(nc);
                        list.add(arr[r][c]);
                    }
                }
            }
        }
    }
}
