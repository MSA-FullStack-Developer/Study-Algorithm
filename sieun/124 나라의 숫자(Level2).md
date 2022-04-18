# 124 나라의 숫자(Level2)

```java
class Solution {
    public String solution(int n) {
        String answer = "";
        // int arr[] = {4, 1, 2}; => 배열 접근해서 가져오면 시간 오래걸림
        while(n > 0){
            // answer = arr[n%3] + answer;
            switch(n%3){
                case 0: answer = "4" + answer; break;
                case 1: answer = "1" + answer; break;
                case 2: answer = "2" + answer ;break;
            }
            if(n%3 == 0) n=n/3-1;
            else n=n/3;
        }
        
        return answer;
    }
}
```

