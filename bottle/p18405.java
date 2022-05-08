import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p18405 {

    static int n, k, s, x, y;
    static int[][] check;
    static boolean[][] visited;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static Queue<Virus> queue = new LinkedList<Virus>();
    static ArrayList<Virus> list = new ArrayList<>();
    static int count = 0;
    static int time = 0;
    static int t = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        check = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                check[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (check[a][b] != 0) {
                    t++; // 바이러스 갯수 (숫자 상관 없이)
                    list.add(new Virus(a, b, check[a][b]));
                }
            }
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            queue.add(list.get(i));
        }

        bfs();
        if (check[x - 1][y - 1] != 0) {
            System.out.println(check[x - 1][y - 1]);
        } else {
            System.out.println("0");
        }
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            Virus num = queue.poll();
            int r = num.x;
            int c = num.y;
            int v_num = num.num;

            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                    if (check[nr][nc] == 0 && !visited[nr][nc]) {
                        check[nr][nc] = v_num;
                        visited[nr][nc] = true;
                        queue.add(new Virus(nr, nc, v_num));
                    }
                }
            }
            count++;
            if (count == t) {
                time++;
                count = 0;
            }

            if (time == s) {
                break;
            }
        }
    }

    static class Virus implements Comparable<Virus> {
        int num;
        int x;
        int y;

        public Virus(int x, int y, int num) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Virus other) {
            if (this.num < other.num) {
                return -1;
            }
            return 1;
        }
    }
}
