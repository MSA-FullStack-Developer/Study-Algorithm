import java.util.HashMap;

public class hash02 {
    public static void main(String[] args) {
        
        String[] phone_book ={"123","456","789"};
        String[] first_number={"123"};
        String answer = "";
        boolean answer_true = true;
        boolean answer_false = false;
        HashMap<String, Integer> answerMap = new HashMap<>();

        for(int i = 1 ; i < phone_book.length ; i++){
            String number = phone_book[i].substring(0, phone_book[0].length());
            if(answerMap.containsKey(number)){
                int count = (int)answerMap.get(number);
                answerMap.put(number, ++count);
            }else{
                answerMap.put(number, 1);
            }
        }
        for(int i = 0 ; i < first_number.length ; i++ ){
            int count = (int)answerMap.get(first_number[i]);
            String number = first_number[i];
            if(count == 1){
                answerMap.remove(number);
            }else{
                answerMap.put(number, --count);
            }
        }

        String temp = answerMap.keySet().toString();
        answer = temp.substring(1, temp.length()-1);
        

        if(answer.isEmpty()){
            System.out.println("값이 없다 ! ");
        }

        // if(answer.isEmpty()){
        //     return answer_true;
        // }
        // else{
        //     return answer_false;
        // }

    }
}
