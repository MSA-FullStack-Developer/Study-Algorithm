import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1010 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long answer = 1L;
            long y_answer = 1L;
            long x_answer = 1L;
            if ((y / 2) < x) {
                x = y - x;
            }
            for (int j = 0; j < x; j++) {
                y_answer *= (y - j);
            }
            for (int j = 0; j < x; j++) {
                x_answer *= (x - j);
            }
            answer = y_answer / x_answer;
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
