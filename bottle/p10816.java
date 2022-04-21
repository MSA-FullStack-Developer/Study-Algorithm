import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : arr1) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        System.out.println(hashMap);
        int[] answer = new int[arr2.length];

        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (hashMap.containsKey(arr2[j])) {
                answer[i] = hashMap.get(arr2[j]);
            } else {
                answer[i] = 0;
            }
            j++;
        }
        for (int i : answer) {
            bw.write(String.valueOf(i) + " ");
        }
        bw.flush();
    }
}