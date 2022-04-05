import java.util.Arrays;
/* 숫자를 문자열로 나타낸 문제에서는 substring or split 등으로 숫자로 표현할 수 있도록 문자열을 나누어 주는 것이 중요하다. */
/* 또한 +, - 기호를 구분해야 할 경우에는 split으로 나눈 후 배열에 넣음으로써 이후에 기호를 고려하지 않도록 해준다.         */

                    /* 주요 메소드 */       
/*          int -> String : Integer.toString         */
/*          String -> int : Integer.parseInt         */
/* 특정 문자 기준으로 문자열 나누기  -> 문자열.split("특정문자") */
/* 정수형 배열 오름차순 정렬 : Arrays.sort()               */

/* 참고 */
/* 정수형 배열 내림차순 정렬 : Arrays.sort(arr,Collections.reverseOrder()); */

public class max_min {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        String[] s1 = s.split(" ");
        int[] num = new int[s1.length];
        String answer = "";

        for(int i = 0 ; i < s1.length ; i++){
            num[i] = Integer.parseInt(s1[i]);
        }

        Arrays.sort(num);
        answer = Integer.toString(num[0]) + " " + Integer.toString(num[num.length-1]);
        System.out.println(answer);
    }
}
