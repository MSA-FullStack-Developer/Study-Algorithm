import java.util.Scanner;

public class p9663 {
    static int[][] check; // 퀸의 위치 표시
    static boolean[][] visited; // 퀸의 방문 여부 표시
    static int n;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        check = new int[n][n];
        visited = new boolean[n][n];

        dfs(0);

        System.out.println(count);
    }

    public static void move(int r, int c) {
        for (int i = r; i < n; i++) {
            visited[i][c] = true;
        } // 같은 행 이동

        int a = r;
        int b = c;
        while (b >= 0 && b < n && a >= 0 && a < n) {
            visited[a++][b--] = true;
        } // 왼쪽 대각선 이동

        while ((r >= 0 && r < n) && c >= 0 && c < n) {
            visited[r++][c++] = true;
        } // 오른쪽 대각선 이동
    }

    public static void dfs(int start) {
        if (start == n) {
            count++;
            return;
        } // 시작지점이 체스판의 크기와 같아지면 return

        for (int i = 0; i < n; i++) {
            if (!visited[start][i]) { // 0,0부터 시작
                visited[start][i] = true; // 방문여부 저장
                check[start][i] = 1;// 퀸 배치

                move(start, i); // 퀸이 움직일수 있는 공간 방문처리
                dfs(start + 1); // 시작지점 한칸(행) 아래로 이동하여 다시 반복

                check[start][i] = 0; // 퀸 제거
                // visited = new boolean[n][n];// 방문 여부 초기화

                for (int a = 0; a < n; a++) {
                    for (int b = 0; b < n; b++) {
                        visited[a][b] = false;
                    }
                }

                for (int j = 0; j < n; j++) { // 이전 상태로 되돌리기
                    for (int k = 0; k < n; k++) {
                        if (check[j][k] == 1) {
                            move(j, k);
                        }
                    }
                }
            }
        }
    }
}
