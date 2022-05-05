import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14502 {
    static int n;
    static int m;
    static int[][] check;
    static boolean[][] visited;
    static int[][] virus;
    static int answer = 0;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new int[n][m];
        visited = new boolean[n][m];
        virus = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                check[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makewall(0);
        System.out.println(answer);
    }

    // 벽이 세워진 check배열을 사용하기 위해 virus 배열에 복사한다.
    // virus에서 2인곳을 queue에 넣고 bfs 로직을 돈다.
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virus[i][j] = check[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (virus[nr][nc] == 0 && !visited[nr][nc]) {
                        virus[nr][nc] = 2;
                        queue.add(nr);
                        queue.add(nc);
                    }
                }

            }

        }
    }

    // 브루트포스 알고리즘을 이용하여 check에서 0인 곳에 벽을 세운다.
    // 벽을 3개 세우면 virus와zero를 호출
    public static void makewall(int cnt) {
        if (cnt == 3) {
            bfs();
            zero();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] == 0) {
                    check[i][j] = 1;
                    makewall(cnt + 1);
                    check[i][j] = 0;
                }
            }
        }
    }

    // 0의 갯수를 세서 count하고 answer에 저장한다.
    // 다음에 들어오는 count값과 계속 비교를 하고 마지막 남은 최대 answer 값을 리턴한다.
    public static void zero() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }
}
