import java.util.*;

public class stock {
    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 2, 3 };
        int[] answer = new int[prices.length];

        Queue<Integer> queue = new LinkedList<Integer>();
        int time = 0;
        int k = 0;
        for (int i = 0; i < prices.length; i++) {
            queue.add(prices[i]);
            for (int j = i + 1; j < prices.length; j++) {
                queue.add(prices[j]);
                time++;
                if (queue.peek() > prices[j]) {
                    queue.clear();
                    break;
                }
            }
            answer[k] = time;
            k++;
            time = 0;
            queue.clear();
        }
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }
}
