public class negative_positive_plus{

    /* 프로그래머스 level1 음양 더하기*/
    /* if문을 통하여 boolean 배열이 true, false 인지 판단한다.*/
    /* false 이면 -1을 곱하여 음수로 바꿔준다.               */
    /* 이후 temp[]배열 순차적으로 저장한다.                  */
    /* foreach 문을 통하여 temp 값을 sum에 넣고 더해준다.    */
    public static void main(String[] args) {
        int[] absolutes ={4,7,12};
        boolean[] bool ={true,false,true};
        int[] temp = new int[absolutes.length];
        int sum = 0;
        for(int i = 0 ; i < absolutes.length ; i++){
            if(bool[i] == true){
                temp[i] = absolutes[i];
            }else temp[i] = (absolutes[i] * -1);
        }
        for (int i : temp) {
            sum += i;
        }
        System.out.println(sum);
    }
}