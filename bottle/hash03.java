import java.util.HashMap;

/* 알고리즘 : 해시 프로그래머스 level2, 위장 */

/* 알고리즘 */
/* 1. 2차원 배열에 있는 옷의 종류는 key, 옷의 이름은 value로 넣는다.                     */
/* 2. 예를들어 value가 2이면 옷의 종류가 2종류라는 뜻이다.                              */
/* 3. 경우의 수는 1번 옷을 입는다, 2번 옷을 입는다, 옷을 집지 않는다 3가지 경우의 수가 나온다.  */
/* 4. value = [1,2] 인 경우가 있으면 (1+1)X(2+1) - 1 을 해주면 된다.                */
/* 5. 1을 빼는 이유는 두 종류의 옷 모두 입지 않았을때 이다.                              */

public class hash03 {
    public static void main(String[] args) {
        HashMap<String, Integer> answerMap = new HashMap<>();
        String[][] clothes = {{"yellowhat", "headgear"},
        {"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
        int answer = 1;
    
        for(int i = 0 ; i < clothes.length ; i++){
            String cloth = clothes[i][1];
            if(answerMap.containsKey(cloth)){
                int count = (int)answerMap.get(cloth);
                answerMap.put(cloth, ++count);
            }else{
                answerMap.put(cloth, 1);
            }
        }
        for (int key : answerMap.values()) {
            answer = answer * (key+1);
        }
        answer = answer -1;
        System.out.println(answer);
    }
    
}
