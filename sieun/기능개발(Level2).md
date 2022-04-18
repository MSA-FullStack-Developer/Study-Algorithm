# 기능개발(Level2)

```java
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        int flag = 0;
        for(int i = 0; i < progresses.length; i++){
            int temp = (100-progresses[i])%speeds[i] == 0?(100-progresses[i])/speeds[i]:(100-progresses[i])/speeds[i]+1;
            //int temp = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
           if(flag >= temp){
                cnt++;
            }else{
                if(flag != 0) list.add(cnt);
                cnt = 1;
                flag = temp;
            }
        }
        
        if(cnt > 0) list.add(cnt);
        
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
```