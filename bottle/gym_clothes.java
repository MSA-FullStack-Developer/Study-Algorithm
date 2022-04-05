import java.util.HashSet;
import java.util.*;

public class gym_clothes{
    /* 자료구조: set                                          */
    /* 주요 메소드 : add(), remove(), contains()               */
    /* 1. 여벌옷이 있는 학생을 Rset에 저장한다.                     */
    /* 2. 옷을 도둑맞은 학생이 Rset에 포함되어 있다면                 */
    /* -> 도둑맞은 학생 = 여벌옷을 가지고 있는 학생                   */
    /* -> Rset에서 해당 학생을 제거한다.                           */
    /* -> 아니라면 Lset에 저장한다                                */
    /* 3. 여벌옷이 있는 학생에서 1뺀 값이 Lset에 들어있으면             */
    /* -> Lset에서 -1뺀 값을 제거한다.                            */
    /* -> 1을 더한 값이 Lset에 들어있으면 Lset에서 1 더한 값을 제거한다. */
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        int answer = 0;
        

        Set<Integer> Rset = new HashSet<>();
        Set<Integer> Lset = new HashSet<>();

        for(int i = 0; i < reserve.length ; i++){
            Rset.add(reserve[i]);
        }

        for(int i = 0; i < lost.length ; i++){
            if(Rset.contains(lost[i])){
                Rset.remove(lost[i]);
            }else{
                Lset.add(lost[i]);
            }
        }

        for (Integer i : Rset) {
            if(Lset.contains(i-1)){
                Lset.remove(i-1);
            }else if(Lset.contains(i+1)){
                Lset.remove(i+1);
            }
        }
        answer = n - Lset.size();
        System.out.println(answer);
    }
}