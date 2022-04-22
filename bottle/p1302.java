import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class p1302 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String i : arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        int maxValue = Collections.max(hashMap.values());
        ArrayList<String> list = new ArrayList<String>(hashMap.keySet());
        Collections.sort(list);
        for (String a : list) {
            if (hashMap.get(a) == maxValue) {
                System.out.println(a);
                break;
            }
        }
    }
}
