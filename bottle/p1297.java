import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p1297 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k != 0) {
                queue.add(k);
            } else {
                if (queue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(queue.peek());
                    queue.poll();
                }
            }
        }
    }
}
