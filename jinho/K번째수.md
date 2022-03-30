## 정렬 - K번째수

### 알고리즘
1. i번째부터 j번째 원소까지 잘라서 `list`에 넣고 오름차순으로 정렬한다.
2. `commands[i][2]`로부터 K번째 수를 구해서 `temp`에 담아준다.
4. 위 과정이 끝날 때마다 `list`를 `clear()`해서 값을 비워준다.

### 소스코드
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=0; i<commands.length; i++) {
            // i번째부터 j번째 원소까지 잘라서 list에 넣기
            for(int j=commands[i][0]-1; j<commands[i][1]; j++)
                list.add(array[j]);
            // 오름차순으로 정렬
            Collections.sort(list);
            // K번째 수를 구해서 temp에 담기
            temp.add(list.get(commands[i][2]-1));
            // list를 재사용하기 위해서 clear
            list.clear();
        }
        // 출력
        int[] answer = temp.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        return answer;
    }
}
```