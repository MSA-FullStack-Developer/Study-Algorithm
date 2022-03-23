import java.util.HashMap;

public class hash03 {
    public static void main(String[] args) {
        HashMap<String, Integer> answerMap = new HashMap<>();
        String[][] clothes = {{"yellowhat", "headgear"},
        {"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
        int answer = 0;
       
        //System.out.println(clothes.length);
        for(int i = 0 ; i < clothes.length ; i++){
            String cloth = clothes[i][1];
            if(answerMap.containsKey(cloth)){
                int count = (int)answerMap.get(cloth);
                answerMap.put(cloth, ++count);
            }else{
                answerMap.put(cloth, 1);
            }
        }
        System.out.println(answerMap.values());
        // for(int i = 0 ; i < answerMap.size() ; i++){
        //     int temp1 = answerMap.values();
        // }

        // answer = answerMap.size() + ()
        // System.out.println(answerMap.size());
    }
    
}
