## 백준 18243번 현수막 (실버 1)

### 문제링크
- https://www.acmicpc.net/problem/18243

### 알고리즘
1. 배열 `grid`의 값들을 각각 무한대로 초기화해준다.
2. `K`개의 줄에 입력으로 주어지는 `a`와 `b`로 `grid[a][b]=1`, `grid[b][a]=1`를 만들어서 `a`와 `b`가 관계가 있음을 표시한다.
3. Floyd-Warshall 알고리즘을 통해서 각 정점 간의 최단거리를 초기화해준다.
4. 인접행렬로 관계를 형성한 2차원 배열 `grid`에 속한 값이 하나라도 6을 넘으면 `Big World!`를 출력하고, 그렇지 않으면 `Small World!`를 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18243 {
    static int N, K;
    static int[][] grid;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());
            grid = new int[N+1][N+1];

            for(int[] item : grid) {
                Arrays.fill(item, 10000000);
            }

            for(int i=0; i<K; i++) {
                token = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                grid[a][b] = 1;
                grid[b][a] = 1;
            }

            for(int k=1; k<=N; k++) {
                for(int i=1; i<=N; i++) {
                    for(int j=1; j<=N; j++) {
                        if(grid[i][j]>grid[i][k]+grid[k][j]) {
                            grid[i][j] = grid[i][k] + grid[k][j];
                        }
                    }
                }
            }

            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(grid[i][j]>6) {
                        bw.write("Big World!\n");
                        bw.close();
                        return;
                    }
                }
            }
            bw.write("Small World!\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```