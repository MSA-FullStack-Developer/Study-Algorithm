import java.util.HashMap;

public class phone_book {
    public static void main(String[] args) {
        String[] phone_book = {"12","123","1235","567","88"};
        int count = 0;
        HashMap<String, String> hashmap = new HashMap<>();
        
        for(int i = 0; i < phone_book.length ; i++){
            hashmap.put(phone_book[i],phone_book[i]);
        }
        System.out.println(hashmap);
        for (String str : phone_book) {
            for(int i = 0 ; i < str.length() ; i++){
                if(hashmap.containsKey(str.substring(0,i))){
                    System.out.println("false");
                }
            }
        }
        System.out.println("true");
    }
}
