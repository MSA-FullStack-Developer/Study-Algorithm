public class h_index {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = 0;
        int up = 0;
        int down = 0;
        while(true){
            for(int i = 0 ; i < citations.length ; i++){
                if(answer <= citations[i]){
                    up++;
                }else{
                    down++;
                }
                
                if(answer == up){
                    break;
                }
            }
            System.out.println(up+" "+down);
            if(answer == up && answer > down){
                break;
            }
            answer++;
            up = 0;
            down = 0;
        }

        System.out.println(answer);
    }
}
