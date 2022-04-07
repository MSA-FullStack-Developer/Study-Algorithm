public class blocking_phone_number {
    public static void main(String[] args) {
        String s = "027778888";
        String s1 = "";
        String s2 = "";
        String answer = "";
        s1 = s.substring(0,s.length()-4);
        s2 = s.substring(s.length()-4, s.length());
        
        for(int i = 0 ; i < s1.length() ; i++){
            answer = "*" + answer;
        }
        answer = answer + s2;
        System.out.println(answer);
    }
}
