import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> hashmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String pocketmon = br.readLine();
            String number = Integer.toString(i + 1);
            hashmap.put(pocketmon, number);
            hashmap.put(number, pocketmon);
        }

        for (int i = 0; i < m; i++) {
            String answer = br.readLine();
            bw.write(hashmap.get(answer) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
