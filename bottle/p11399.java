import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            sum += queue.peek();
            arr[i] = sum;
            queue.poll();
        }

        int answer = 0;
        for (int i : arr) {
            answer += i;
        }
        System.out.println(answer);

    }
}
