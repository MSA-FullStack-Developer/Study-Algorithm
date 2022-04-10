import java.util.*;
public class two_num_add {
    public static void main(String[] args) {
        int[] numbers = {5,0,2,7};
        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < numbers.length ; i++){
            for(int j = i+1 ; j < numbers.length ; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        int k = 0;
        for (int s : set) {
            answer[k] = s;
            System.out.print(answer[k]+"");
            k++;
        }
        /*   Arrays.sort(answer)  */
        /*    return answer       */
    }
}
