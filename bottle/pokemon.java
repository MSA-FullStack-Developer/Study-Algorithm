import java.util.HashSet;
import java.util.Set;

public class pokemon {
    public static void main(String[] args) {
        int[] nums = {1,1,3,4,5,6};
        int answer = 0;
        int mid = nums.length/2;

        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }

        if(set.size() <= mid){
            answer = set.size();
        }else{
            answer = mid;
        }

        System.out.println(answer);
    }
}
