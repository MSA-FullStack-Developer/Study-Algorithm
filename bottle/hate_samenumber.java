import java.util.*;

public class hate_samenumber {
    public int[] solution(int []arr) {
        int j = 0; 
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length -1; i++) {
            if(arr[i] != arr[i+1]) {
                temp[j++] = arr[i];
            }        
        }
        temp[j++] = arr[arr.length-1];
        
        int[] answer = new int[j];
        for (int i = 0; i < j; i++) {
            answer[i] = temp[i];
        }
        
        return answer;
    }
}