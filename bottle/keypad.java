public class keypad {
    public static void main(String[] args) {
        int[] number ={7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int left = 10;
        int right = 12;
        int LDistance = 0;
        int RDistance = 0;
        int[] temp = new int[number.length];
        String hand ="left";
        
        String answer = "";

        for(int i = 0 ; i < number.length ; i++){
            if(number[i] == 0){
                number[i] = 11;
            }
           if(number[i] % 3 == 1){
            temp[i] = 1;
            left = number[i];
           }else if(number[i] % 3 == 2){

                LDistance = (Math.abs(left - number[i]) % 3) + (Math.abs(left - number[i]) / 3);
                RDistance = (Math.abs(right - number[i]) % 3) + (Math.abs(right - number[i]) / 3);
                if(LDistance > RDistance){
                    temp[i] = 2;
                    right = number[i];
                }else if(LDistance < RDistance){
                    temp[i] = 1;
                    left = number[i];
                }else{
                    if(hand.equals("right")){
                        temp[i] = 2;
                        right = number[i];
                    }else{
                        temp[i] = 1;
                        left = number[i];
                    }
                }
           }else {
               temp[i] = 2;
               right = number[i];
           }
        }
        for (int i : temp) {
            if(i==1){
                answer += "L";
            }else answer += "R";
        }
        System.out.println(answer);

    }
}