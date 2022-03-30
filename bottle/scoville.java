import java.util.PriorityQueue;

public class scoville{

    /* 모든 음식의 스코빌 지수를 k 이상으로 만들 수 없는 경우에는 -1 return */
    /* PriorityQueue 사용                                       */
    /* PriorityQueue의 내부 구조는 힙 구조이다.                      */
    /* 별도의 정렬 과정 없이 offer 하였을 때 자기 자신의 자리를 찾아간다.    */
    /* 우선순위에 대한 기준을 세울 수 있어야 한다.                       */
    /* PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();                           낮은 숫자 순 */
    /* PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); 높은 숫자 순 */
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        int count = 0;
        int failure = 1;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0 ; i < scoville.length ; i++){
            queue.add(scoville[i]);
        }
        
        for(int i = 0 ; i < scoville.length -1 ; i++){
            if(queue.peek() < k){
                int a = queue.poll();
                int b = queue.poll();
                int result = a + b * 2;
                queue.offer(result);
                count++;
            }else{
                break;
            }
        }
        if(queue.peek() < k){
            System.out.println(failure * -1);
        }else{
            System.out.println(count);
        }
    }
}