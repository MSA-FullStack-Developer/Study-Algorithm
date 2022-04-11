import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
public class truck {
    /* 다시 풀기 : testcase1 만족 */
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights={7,4,5,6};
        int answer = 0;
        
        Queue<Integer> queue_Ready =  new LinkedList<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < truck_weights.length ; i++){
            queue_Ready.add(truck_weights[i]);
        }
        
        int truck_sum = 0;
        int count = 0;
        while(true){
            for (Integer st : list) {
                truck_sum += st;
            }
            if(list.size()< bridge_length && truck_sum + queue_Ready.peek() <= weight && !queue_Ready.isEmpty()){
                list.add(queue_Ready.peek());
                queue_Ready.remove();
                count++;
                System.out.print(queue_Ready + " "+list);
                System.out.println(" ");
            }
            for (Integer st : list) {
                truck_sum += st;
            }
            if(!queue_Ready.isEmpty() && truck_sum + queue_Ready.peek() <= weight){
                truck_sum += queue_Ready.peek();
                list.add((queue_Ready.peek()));
                queue_Ready.remove();
                count++;
                System.out.print(queue_Ready + " "+list);
                System.out.println(" ");
            }else{
                list.remove(0);
                count++;
                System.out.print(queue_Ready + " "+list);
                System.out.println(" ");
            }
            truck_sum = 0;
            if(list.isEmpty() && queue_Ready.isEmpty()){
                break;
            }//다리를 지나는 트럭과 대기 트럭이 모두 비어있을 때
        }

        System.out.println(count);
    }
}
