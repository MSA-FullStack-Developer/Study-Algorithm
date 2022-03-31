import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class failure_rate {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] answer = new int[N];
        double[] user = new double[N+1];

        for(int i : stages){
            if(i == N+1){
                continue;
            }
            user[i]++;
        }
        ArrayList<Double> fail = new ArrayList<Double>();

        //스테이지에 도달한 명수
        double num =stages.length;
        //다음 스테이지로 올라갈때 줄어드는 사용자수를 계산하기 위해 사용
        double tmp = 0;

        //실패율을 구한 후 다시 stage배열에 담고, fail 리스트에도 담아준다.
        for(int i=1; i<user.length; i++){
            tmp = user[i];
            // 도달한 사용자 수가 0 일때, 실패율도 0
            if(num == 0){
                user[i]=0;
            }else{
                user[i] = user[i]/num;
                num = num - tmp;
            }
            fail.add(user[i]);
      }

     //  fail 리스트를 내림차순으로 정렬해준다.
     Collections.sort(fail,Collections.reverseOrder());

     //정렬된 fail리스트 값과 stage값을 비교해서 같으면 stage의 인덱스번호(스테이지번호)를 가져옴으로써
     //실패율이 높은 순으로 answer배열에 넣어준다.
     for(int i=0; i<fail.size(); i++){
         for(int j=1; j<user.length; j++){
             if(fail.get(i) == user[j]){
                 answer[i] = j;
                 user[j] = -1;
                 break;
            }
        }
    }
    for (int a : answer) {
        System.out.println(a);
    }   
  }
}

