import java.util.*;

class Solution {

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static boolean[][] visited;
    static int[][] arr;

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int answer = 0;
        visited = new boolean[n + 1][m + 1];
        arr = new int[n + 1][m + 1];

        dfs(0, 0, maps, n, m);

        if (arr[n - 1][m - 1] != 0) {
            answer = arr[n - 1][m - 1];
        } else {
            answer = -1;
        }
        return answer;
    }

    public static void dfs(int r, int c, int[][] maps, int n, int m) {
        Queue<Miro> queue = new LinkedList<Miro>();
        queue.add(new Miro(r, c));
        visited[r][c] = true;
        arr[r][c] = 1;

        while (!queue.isEmpty()) {
            Miro miro = queue.poll();
            r = miro.x;
            c = miro.y;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (maps[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        arr[nr][nc] = arr[r][c] + 1;
                        queue.add(new Miro(nr, nc));
                    }
                }
            }
        }
    }
}

class Miro {
    int x, y;

    public Miro(int x, int y) {
        this.x = x;
        this.y = y;
    }
}