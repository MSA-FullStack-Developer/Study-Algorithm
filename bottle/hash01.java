import java.util.HashMap;

public class hash01 {

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
        }

        for(int i = 0 ; i < completion.length ; i++){
            int count = (int) answerMap.get(completion[i]);
            String name = completion[i];
            if(count == 1){
                answerMap.remove(name);
            }else{
                answerMap.put(name, --count);
            }
        }
        String temp = answerMap.keySet().toString();
        answer = temp.substring(1, temp.length()-1);
        System.out.println(answer);

    }
}
