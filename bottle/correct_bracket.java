import java.util.Stack;

public class correct_bracket {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String s = "()()";
        boolean answer = true;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(0) != ')'){
                if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
                }else {
                    if(stack.isEmpty()){
                        continue;
                    }else stack.pop();
                }
            }else{
                answer = false;
                break;
            }
        }
        if(stack.isEmpty()){
            System.out.println(answer);
        }else System.out.println(!answer);
    }
    
}
