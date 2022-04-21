# 다리를 지나는 트럭(Level2)

```java
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        
        int idx = 0, totalWeight = 0;
        while(idx < truck_weights.length){
            // 다리가 꽉 찬 경우 하나 빼기
            if(q.size() == bridge_length) {
                totalWeight -= q.poll(); 
            }
            // 다음 트럭이 올라갈 수 있으면 올라가기 answer++
            // 다음 트럭이 올라갈 수 없으면 0넣기 answer++
            if(totalWeight + truck_weights[idx] <= weight){
                totalWeight += truck_weights[idx];
                q.offer(truck_weights[idx]); answer++;
                idx++;
            }else{
                q.offer(0); answer++;
            }
        }
        answer += bridge_length;
        return answer;
    }
}
```