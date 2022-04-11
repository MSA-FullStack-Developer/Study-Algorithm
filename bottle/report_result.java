import java.util.*;

public class report_result {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        String[] k_answer = new String[report.length]; 
        String[] v_answer = new String[report.length];
        int k = 2;
        int[] ret = new int[id_list.length];

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, ArrayList<Integer>> list = new HashMap<String, ArrayList<Integer>>();
        
        for(int i = 0 ; i < id_list.length ; i++){
            map.put(id_list[i], i);
        }
        //사람의 이름과 순번을 초기화 한다. 
        //integer값으로 사람을 판별하기 위함.
        System.out.println(map);

        for(int i = 0 ; i < report.length ; i++){
            int idx = report[i].indexOf(" ");
            k_answer[i] = report[i].substring(0, idx);
            v_answer[i] = report[i].substring(idx+1);

            if(!list.containsKey(v_answer[i])){
                list.put(v_answer[i], new ArrayList<>());
            }
            //신고당한사람이 리스트에 없으면 리스트에 key = 신고당한사람, value = 리스트형식으로 주입한다.

            ArrayList<Integer> temp =  list.get(v_answer[i]);
            //list에 신고당한사람의 value(int값)으로 선언.

            if(!temp.contains(map.get(k_answer[i]))){
                temp.add(map.get(k_answer[i]));
            }
            //신고 당한사람이 temp에 있으면 신고당한사람의 value(int값) temp에 주입한다.
            System.out.println(list);
        }

        System.out.println(list);

        for(int i = 0 ; i < id_list.length ; i++){
            String id = id_list[i];
            if(list.containsKey(id) && list.get(id).size()>=k){
                for(int idx : list.get(id)){
                    ret[idx]++;
                }
            }  
        }
        //id값(key : 신고당한사람)이 list에 있고, value의 size가 k보다 크거나 같으면
        //비어있는 배열 idx에 신고당한사람의 index를 찾아서 배열값에 1을 더해준다.

        for(int i = 0 ; i < ret.length ; i++){
            System.out.println(ret[i]);
        }
    }
}
