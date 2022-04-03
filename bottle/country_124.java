public class country_124 {
    public static void main(String[] args) {
        int n = 15;
        String answer = "";
        String[] country_124 = {"4", "1", "2"};
        String temp = "";
        
        while(true){
            if(n % 3 == 0){
                temp = country_124[0];
            }else if(n % 3 == 1){
                temp = country_124[1];
            }else{
                temp = country_124[2];
            }
            if(n % 3 == 0){
                n--;
            }
            n = n / 3;
            answer = temp + answer;
            temp = "";
            if(n == 0){
                break;
            }
        }
        System.out.println(answer);

    }
}
