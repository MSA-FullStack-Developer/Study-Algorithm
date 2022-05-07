## 백준 13023 ABCDE (골드 5)

### 문제링크
- https://www.acmicpc.net/problem/13023

### 알고리즘
1. 양방향 리스트를 사용하기 위해서 인접리스트 `list`를 만들어준다.
2. 입력받은 값들을 통해서 `list`를 초기화해준 후에 각각의 정점들에 대해서 DFS를 수행한다.
3. DFS를 진입하면 `depth`를 1 증가시키고 `visited[x]`의 값을 `true`로 바꿔준다.
4. `depth` 값이 5인지 확인해서 맞으면, 조건에 부합하는 관계를 찾았음을 표시하기 위해서 `answer` 값을 1로 바꾸고 해당 메소드를 빠져나온다.
5. 또한, 인접한 정점들에 대해서 재귀적으로 DFS를 수행하는 와중에 `answer` 값이 1로 바뀌면 메소드를 빠져나온다.
6. 현재 정점과 인접한 정점들에 대해서 DFS가 끝나면 다른 경로를 탐색해야만 하므로 `visited[x]` 값을 `false`로 바꾸고 `depth`를 1 감소시켜서 기존 상태로 되돌려준다.
7. 각각의 정점들에 대해서 DFS를 수행하기 전에 `answer`를 확인해서 값이 1이면 반복문을 탈출한 후에 값을 출력한다.

### 소스코드
```java
package com.algorithm.baekjoon;

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
            if(answer==1) return; // 조건을 만족하면 바로 탈출
        }
        visited[x] = false; // back-tracking
        depth--; // back-tracking
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
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            for(int i=0; i<N; i++) {
                if(answer==0) dfs(i);
                else break;
            }

            bw.write(answer+"\n");
            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
```