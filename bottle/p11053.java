import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11053 {
    // BOJ11053 가장 긴 증가하는 부분 수열
    // 알고리즘 분류 : DP
    // 풀이방법
    // 인덱스값 저장용 배열을 만든다.
    // 1. 해당 배열의 값을 기준으로 이전 배열 모두와 비교한다.
    // 만약 기준 배열의 값이 이전 배열 보다 크면 해당 배열의 인덱스값을 1 증가시킨다.
    // 2. if 조건문 해석
    // 기준이 되는 배열이 이전 배열보다 커야한다. 그리고 기준이 되는 배열에 매치되는 인덱스 배열에서의 값이 비교 대상의 인덱스 값보다 작아야
    // 함
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T + 1];
        int[] idx = new int[T + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        idx[0] = 1;
        for (int i = 1; i < T; i++) {
            idx[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && idx[i] <= idx[j]) {
                    idx[i] = idx[j] + 1;
                }
            }
        }
        Arrays.sort(idx);
        bw.write(idx[idx.length - 1] + "\n");
        bw.flush();
        bw.close();

    }
}
