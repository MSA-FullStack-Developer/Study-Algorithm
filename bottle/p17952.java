import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17952 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int sum = 0;
        int count = n;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                for (int j = 0; j < 2; j++) {
                    stack.push(Integer.parseInt(st.nextToken()));
                }
                if (stack.peek() == 1) {
                    stack.pop();
                    sum += stack.peek();
                    stack.pop();
                } else {
                    int temp;
                    temp = stack.peek() - 1;
                    stack.pop();
                    stack.push(temp);
                }
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == 1) {
                        stack.pop();
                        sum += stack.peek();
                        stack.pop();
                    } else {
                        int temp;
                        temp = stack.peek() - 1;
                        stack.pop();
                        stack.push(temp);
                    }
                }
            }
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }

}
