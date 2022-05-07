## 백준 1260번 DFS와 BFS (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/1260

### 알고리즘
1. DFS로 탐색한 결과와 BFS로 탐색한 결과를 저장하기 위해서 `dfs_result`, `bfs_result`를 각각 만들어준다.
2. 방문할 정점이 여러 개인 경우에 값이 작은 정점을 먼저 방문해줘야 하므로 만들어진 관계들을 `list`로 입력받은 후에 내부의 리스트들을 오름차순으로 정렬시켜준다.
3. DFS, BFS를 통해서 만들어진 결과들을 각각 `dfs_result`, `bfs_result`에 넣어주고 탐색이 모두 끝나면 한번에 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.*;

public class BOJ1260 {
    static int N, M, V;
    static boolean[] visited;
    static List<Integer> dfs_result;
    static List<Integer> bfs_result;
    static List<List<Integer>> list;
    static void dfs(int x) {
        dfs_result.add(x);
        visited[x] = true;
        for(int i=0; i<list.get(x).size(); i++) {
            int next = list.get(x).get(i);
            if(!visited[next]) dfs(next);
        }
    }
    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        bfs_result.add(x);
        visited[x] = true;
        q.offer(x);
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i=0; i<list.get(node).size(); i++) {
                int next = list.get(node).get(i);
                if(!visited[next]) {
                    bfs_result.add(next);
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            V = Integer.parseInt(token.nextToken());

            list = new ArrayList<>();
            for(int i=0; i<=N; i++)
                list.add(new ArrayList<>());
            dfs_result = new ArrayList<>();
            bfs_result = new ArrayList<>();
            visited = new boolean[N+1];

            for(int i=0; i<M; i++) {
                token = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            for(List<Integer> item : list) {
                Collections.sort(item);
            }

            dfs(V);
            Arrays.fill(visited, false);
            bfs(V);

            for(int item : dfs_result)
                bw.write(item+" ");
            bw.write("\n");
            for(int item : bfs_result)
                bw.write(item+" ");
            bw.write("\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```