# 오픈채팅방(Level2)

```java
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        int size = 0;
        Map<String, String> map = new HashMap<>();
        
        for(int i = 0; i < record.length; i++){
            String[] str = record[i].split(" ");
            // user 정보 입력
            if(!str[0].equals("Leave")) map.put(str[1], str[2]);
            if(!str[0].equals("Change")) size++;
        }
        
        
        // 채팅방 문자기록 출력
        answer = new String[size];
        int idx = 0;
        for(int i = 0; i < record.length; i++){
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter")) answer[idx++] = map.get(str[1]) + "님이 들어왔습니다.";
            else if(str[0].equals("Leave")) answer[idx++] = map.get(str[1]) + "님이 나갔습니다.";
        }
        
        return answer;
    }
}
```