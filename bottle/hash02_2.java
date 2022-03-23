import java.util.HashMap;
import java.util.jar.Attributes.Name;

public class hash02_2 {
    public static void main(String[] args) {
        String[] phone_book = {"12","123","1235","567","88"};
        int abc = 0;

        int a = phone_book[0].length();

        HashMap<String, Integer> answerMap = new HashMap<>();

        for(int i = 1; i < phone_book.length ; i++){
            String number = phone_book[i];
            answerMap.put(number,1);
        }
       
        for (String key : answerMap.keySet()) {
            if(a <= key.length() ){
                int key2 = Integer.parseInt(key.substring(0,a));
                if(Integer.parseInt(phone_book[0]) == key2){
                    abc++;
                }
            }
        }

        if(abc > 0){
            System.out.println("false");
        }else System.out.println("true");

    }
}
