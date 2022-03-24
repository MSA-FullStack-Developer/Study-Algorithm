import java.util.LinkedList;
import java.util.Queue;


public class stack_queue01 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int temp[] = new int[100];
        int day = 0;
        int count = 0;
        
        for(int i = 0 ; i < progresses.length ; i ++){
            while(progresses[i] + (day * speeds[i]) < 100){
                day++;
            }
            sysefwf
            temp[day]++;
        }
        
        for (int i : temp) {
            if(i !=0){
                count++;
            }
        }
        int[] answer = new int[count];
        count=0;
        for (int i : temp) {
             if(i != 0){
                 answer[count++] = i;
            }
        }

    }
}   
