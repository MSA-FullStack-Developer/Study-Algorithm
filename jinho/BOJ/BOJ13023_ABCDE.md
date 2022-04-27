## 백준 13023 ABCDE (골드 5)

### 문제링크
- https://www.acmicpc.net/problem/13023

### 알고리즘
1. 양방향 리스트를 사용하기 위해서 인접리스트 `list`를 만들어준다.
2. 입력받은 값들을 통해서 `list`를 초기화해준 후에 `!visitd[i]`인 경우에 DFS를 수행한다.
3. DFS를 진입하면 `depth`를 1 증가시키고 `visited[x]`의 값을 `true`로 바꿔준다.
4. `depth` 값이 5인지 확인해서 맞다면, 조건에 부합하는 관계를 찾았음을 표시하기 위해서 `answer` 값을 1로 바꾸고 해당 메소드를 빠져나온다.
5. 인접한 모든 정점들에 대해 재귀적으로 DFS를 수행을 마치면, `answer` 값이 1이라면 메소드를 빠져나온다.
6. 만약에 `answer` 값이 1이 아니라면, 백트래킹을 통해서 다른 경로를 탐색해야만 하므로 `visited[x]` 값을 `false`로 바꾸고 `depth`를 1 감소시킨다.
7. 위의 과정을 모든 정점들에 대해서 진행한 후 `answer` 값을 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13023 {
    static int N, M, depth, answer;
    static boolean[] visited;
    static List<List<Integer>> list;
    static void dfs(int x) {
        depth++;
        visited[x] = true;
        if(depth==5) {
            answer = 1;
            return;
        }
        for(int i=0; i<list.get(x).size(); i++) {
            int next = list.get(x).get(i);
            if(!visited[next]) dfs(next);
        }
        if(answer==1) return; // 조건을 만족하는지만 확인하면 되므로 바로 탈출
        visited[x] = false;
        depth--;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            visited = new boolean[N];

            list = new ArrayList<>();
            for(int i=0; i<N; i++) {
                list.add(new ArrayList<>());
            }

            for(int i=0; i<M; i++) {
                token = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(token.nextToken());
                int v2 = Integer.parseInt(token.nextToken());
                list.get(v1).add(v2);
                list.get(v2).add(v1);
            }

            for(int i=0; i<N; i++) {
                if(!visited[i]) dfs(i);
            }

            bw.write(answer+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```