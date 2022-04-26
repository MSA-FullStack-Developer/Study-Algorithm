# 카카오프렌즈 컬러링북(Level2)

```java
import java.util.*;

class Solution {
    // 행과 열 정보를 저장하는 클래스
    static class Node{
        private int r, c;
        
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1,0,1,0}; // 위, 오른쪽, 아래, 왼쪽 방향
    static int[] dc = {0,1,0,-1};
    static boolean[][] visited; // 방문 여부
    static int M, N;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        M = m; N = n;
        
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
							 // 방문을 하지 않았으면서 색칠이 되어 있는 곳을 bfs로 탐색
                if(!visited[i][j] && picture[i][j] != 0){
                    numberOfArea++;
                    int areaSize = bfs(picture, i, j);
                    maxSizeOfOneArea = areaSize > maxSizeOfOneArea ? areaSize : maxSizeOfOneArea;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private static int bfs(int[][] picture, int r, int c){
        int areaSize = 1;
        Queue<Node> q = new LinkedList<>();
        int start = picture[r][c]; // 시작 위치 색
        q.add(new Node(r,c)); // 시작위치
        visited[r][c] = true;
        
        while(!q.isEmpty()){
            Node t = q.poll();
						// 방향을 돌아가며 탐색
            for(int i = 0; i < 4; i++){
                int nr = t.r + dr[i];
                int nc = t.c + dc[i];
                if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && picture[nr][nc] == start){
                    visited[nr][nc] = true;
                    areaSize++;
                    q.add(new Node(nr,nc));
                }
            }
        }
        
        return areaSize;
    }
}
```