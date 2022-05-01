import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//BOJ9461 파도반 수열 (실버 3)
public class p9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        Long[] arr = new Long[101];
        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[1] = 1L;
            arr[2] = 1L;
            arr[3] = 1L;
            if (n >= 4) {
                for (int j = 4; j <= n; j++) {
                    arr[j] = arr[j - 3] + arr[j - 2];
                }
            }
            bw.write(arr[n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
