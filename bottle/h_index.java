import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        int k = 0;
        int h_index = 0;
        int up = 0;
        int down = 0;
        Arrays.sort(citations);

        while (true) {
            if (k == citations.length + 1) {
                break;
            }

            for (int i = 0; i < citations.length; i++) {
                if (h_index <= citations[i]) {
                    up++;
                } else {
                    down++;
                }
            }

            if (up >= h_index) {
                list.add(h_index);
            }

            h_index++;
            k++;
            up = 0;
            down = 0;
        }
        if (citations.length == 1) {
            answer = citations[0];
        } else {
            Collections.sort(list);
            answer = list.get(list.size() - 1);
        }
        return answer;
    }
}