import java.util.HashMap;



/* hash 사용하지 않고 풀어보니 런타임 에러 */
public class hash02_1 {
    public static void main(String[] args) {
        
        String[] phone_book ={"12","123","1235","567","88"};
        boolean answer = true;
        int count = 0;

        for(int i = 1 ; i < phone_book.length ; i++){
            String number = phone_book[i].substring(0, phone_book[0].length());
            System.out.println(number);
            if(number.equals(phone_book[0])){
                count++;
            }
        }

        System.out.println(count);
        if(count > 0){
             answer = false;
         }else answer = true;

         System.out.println(answer);
    }
}
