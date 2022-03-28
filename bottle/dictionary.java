import java.util.HashMap;

public class dictionary {
    public static void main(String[] args) {
       
        int[] x = {781, 156, 31, 6, 1};
        String s = "EIO";
        String str = "AEIOU";
        int answer = s.length();

        for(int i = 0 ; i < s.length() ; i++){
            int idx = str.indexOf(s.charAt(i));//indexof : 특정 문자열 
            answer += x[i] * idx;
        }
        System.out.println(answer);
    }
    
}
