# H-Index(Level2)

```java
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = citations.length;
        Arrays.sort(citations);
        
        int idx = citations.length;
        while(true){
            // answer 이상인 idx 위치 찾기
            while(idx-1 >= 0 && citations[idx-1] >= answer){
                idx--;
            }
            // h(answer)번 이상 인용된 논문이 h편이상, 나머지가 h번 이하일때 리턴
            if(citations.length-idx >= answer && idx <= answer) break;
            else answer--;
        }
        return answer;
    }
}
```

