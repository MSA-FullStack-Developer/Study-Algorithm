public class StringToInteger{
    public static void main(String[] args) {
        String[] str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] num = {"0","1","2","3","4","5","6","7","8","9"};
        int answer = 0;
        String s ="one4seveneight";
        
        for(int i = 0 ; i < str.length ; i++){
            s = s.replace(str[i], num[i]);
        }
        
        answer = Integer.parseInt(s);

        System.out.println(answer);

        

    }
}