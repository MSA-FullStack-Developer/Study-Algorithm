import java.util.*;

public class mock_test {

    public int grade(int[] ans, int[] student, int cnt){
        int n = 0;
        for(int i = 0; i < ans.length ; i++){
            if(ans[i] == student[n]){
                cnt++;
            }
            n++;
            if(n == student.length){
            n = 0;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] answer ={1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2};
        int[] student_1 = {1, 2, 3, 4, 5};
        int[] student_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        mock_test gr = new mock_test();
        
        int cnt_1 = gr.grade(answer, student_1, 0);
        int cnt_2 = gr.grade(answer, student_2, 0);
        int cnt_3 = gr.grade(answer, student_3, 0);

        System.out.println(cnt_1);
        System.out.println(cnt_2);
        System.out.println(cnt_3);

        ArrayList<Integer> list =  new ArrayList<>();
        int max = Math.max(Math.max(cnt_1, cnt_2),cnt_3);
        if(max == cnt_1) list.add(1);
        if(max == cnt_2) list.add(2);
        if(max == cnt_3) list.add(3);

        int[] top_grade = new int[list.size()];
        for(int i = 0 ; i < top_grade.length ; i++){
            top_grade[i] = list.get(i);
            System.out.print(top_grade[i]+" ");
        }
    }
}
        // Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // List<Integer> keySetList = new ArrayList<>(map.keySet());

        // Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
        
        // for(Integer key : keySetList) {
		// 	System.out.println("key : " + key + " / " + "value : " + map.get(key));
		// }

        // map.put(1, cnt_1);
        // map.put(2, cnt_2);
        // map.put(3, cnt_3);