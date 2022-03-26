import java.util.HashMap;

public class hash01 {
    /* 주석 추가 !! */

    public static void main(String[] args) {
        
        String answer = " ";
        String[] participant = {"mislav","stanko","mislav","ana"};
        String[] completion = {"stanko","ana","mislav"};
        HashMap<String, Integer> answerMap = new HashMap<>();
    
        for(int i = 0 ; i < participant.length; i++){
            String name = participant[i];
            if(answerMap.containsKey(name)){
                int count = (int)answerMap.get(name);
                answerMap.put(name, ++count);
            }else{
                answerMap.put(name, 1);
            }
            //name값이 없으면 name, 1 저장
            //name값이 있으면 name 값에 따른 hash 값을 count에 저장
            // -> 1증가 시켜서 answerMap에 저장
        }

        for(int i = 0 ; i < completion.length ; i++){
            int count = (int) answerMap.get(completion[i]);
            //answerMap에 완주자 hash 값을 받아와서 count에 저장
            String name = completion[i];
            if(count == 1){
                answerMap.remove(name);
            }else{
                answerMap.put(name, --count);
            }
            //count가 1이상이면 : 동명이인이 있다면 -> 1개 제거
            //count가 1이면 : 완전 제거
        }
        String temp = answerMap.keySet().toString();
        
        //keySet()은 key 값만 출력  
        //values()는 value 값만 출력
        answer = temp.substring(1, temp.length()-1);
        //[] 대괄호 삭제 
        //문자열의 양끝을 제거할 때 주로 사용 substring(1, temp.length() - 1);
        System.out.println(answer);

    }
}
