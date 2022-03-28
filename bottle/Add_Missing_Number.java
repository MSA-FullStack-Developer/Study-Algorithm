/* 해시 프로그래머스 level1, 없는 숫자 더하기  */
/* 1. 0 ~ 9의 합으로 temp를 초기화 한다.    */
/* 2. 배열값을 순서대로 temp에서 빼준다.      */
/* 3. return temp                      */

public class Add_Missing_Number {
    public static void main(String[] args) {
        int[] number = {5,8,4,0,6,7,9};
        int temp = 45;
        for(int i = 0 ; i < number.length ; i++){
            temp -= number[i];
        }
        System.out.println(temp);

    }
}
