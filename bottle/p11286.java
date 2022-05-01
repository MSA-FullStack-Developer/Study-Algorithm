import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (o1, o2) -> Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2)
                        : Integer.compare(Math.abs(o1), Math.abs(o2)));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k != 0) {
                queue.add(k);
                System.out.println(queue);
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
