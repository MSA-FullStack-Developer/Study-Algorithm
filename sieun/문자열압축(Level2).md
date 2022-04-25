# 문자열압축(Level2)

```java
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
				// num => 압축 길이
        for(int num = 1; num < s.length(); num++){
            int count = 0, minLen = 0, i = 0;
            for(i = num; i <= s.length()-num && minLen < answer; i += num){
								// 전 문자열과 같을 경우 count 증가
                if(s.substring(i-num,i).equals(s.substring(i,i+num))){
                    count++;
                }else{
										// 전 문자열과 다를 경우 count 자릿수 + 압축길이를 더해줌
                    if(count > 0) minLen += num + ((count+1) < 10 ? 1 : (count+1) < 100 ? 2 : (count+1) < 1000 ? 3 : 4);
                    else minLen += num;
                    count = 0;
                }
            }
            if(count > 0) minLen += num + ((count+1) < 10 ? 1 : (count+1) < 100 ? 2 : (count+1) < 1000 ? 3 : 4);
            else minLen += num;
						// 나머지 문자열 길이 더해주기
            if(i < s.length()) minLen += s.length() - i;
						// 최소 길이
            answer = minLen < answer ? minLen : answer;
        }
        return answer;
    }
}
```