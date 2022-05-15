# 튜플(Level2)

```java
import java.util.*;
class Solution {
    public int[] solution(String s) {
        // {와 }를 제거한 숫자 형식의 string 배열로 변환
        s = s.replaceAll("\\{\\{","");
        s = s.replaceAll("}}","");
        String[] arr = s.split("},\\{");
        
        int[] answer = new int[arr.length];
        
        // 길이가 짧은 순서대로 정렬
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String o1, String o2){
                return o1.length()-o2.length();
            }
        });
        
        int idx = 0;
        int[] number = new int[100001];
        for(int i = 0 ; i < arr.length; i++){
            String[] temp = arr[i].split(",");
            for(String str: temp){
                // int형으로 변환
                int num = Integer.parseInt(str);
                // answer에 추가한 숫자가 아닌 경우 answer에 숫자 추가
                if(number[num] == 0){
                    answer[idx++] = num;
                    number[num] = 1;
                }
            }
        }
        
        return answer;
    }
}
```

```java
import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] arr = s.replaceAll("\\{\\{","").replaceAll("}}","").split("},\\{");
        
        int[] answer = new int[arr.length];
        
        // 람다식으로
        Arrays.sort(arr, (o1, o2) -> o1.length()-o2.length());
        
        int idx = 0;
        int[] number = new int[100001];
        for(int i = 0 ; i < arr.length; i++){
            String[] temp = arr[i].split(",");
            for(String str: temp){
                int num = Integer.parseInt(str);
                if(number[num] == 0){
                    answer[idx++] = num;
                    number[num] = 1;
                }
            }
        }
        
        return answer;
    }
}
```