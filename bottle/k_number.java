import java.util.Collections;
import java.util.LinkedList;

public class k_number {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
        int[] answer = new int[commands.length];
        LinkedList<Integer> list = new LinkedList<>();
       
        for(int i = 0; i < commands.length ; i++){
            for(int j = commands[i][0]-1 ; j < commands[i][1]; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            //System.out.println(list.get(commands[i][2]-1));
            answer[i] = list.get(commands[i][2]-1);
            list.clear();
            System.out.println();
        }
        for (Integer an : answer) {
            System.out.print(an+" ");
        }
    }
}

/* 리스트 내림차순 정렬 : Collections.sort(list,Collections.reverseOrder()) */