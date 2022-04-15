public class next_Upnumber {
    public static void main(String[] args) {
        int n = 78;
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        int count1 = 0;
        int count2 = 0;
        for(int i = 0 ; i < binary.length() ; i++){
            String s1 = binary.substring(i, i+1);
            if(s1.equals("1")){
                count1++;
            }
        }
        int num = n+1;
        while(true){
            String bnum = Integer.toBinaryString(num);
            for(int i = 0 ; i < bnum.length() ; i++){
                String s2 = bnum.substring(i, i+1);
                if(s2.equals("1")){
                    count2++;
                }
            }
            if(count1 == count2){
                break;
            }else{
                num++;
                count2=0;
            }
        }
        System.out.println(num);


        //System.out.println(count);
    }
}
