# 프린터(Level2)

```java
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 프린터 목록을 큐에 담기
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            q.offer(priorities[i]);
        }
        
        // 우선순위를 오름차순으로 정렬
        Arrays.sort(priorities);
        int idx = priorities.length-1;
        
        while(!q.isEmpty() && idx >= 0){
            int temp = q.poll();
            // 제일 앞 프린터가 중요도가 제일 클 경우 
            if(temp == priorities[idx]){
                answer++;
                if(location == 0) break;
                location--;
                idx--;
            }else{ // 중요도가 제일 크지 않은 경우 다시 큐에 넣음.
                q.offer(temp);
                if(location == 0) location = q.size()-1;
                else location--;
            }
        }
        return answer;
    }
}
```