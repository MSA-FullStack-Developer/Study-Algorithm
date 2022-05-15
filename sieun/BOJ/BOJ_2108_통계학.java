import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2108_통계학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		int[] num = new int[8001];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			if(arr[i] >=0) num[arr[i]]++;
			else num[Math.abs(arr[i])+4000]++;
		}
		
		int maxcnt = -1;
		int maxnum = 0;
		int flag = 0;
		for(int i = 8000; i > 4000; i--) {
			if(maxcnt < num[i]) {
				maxcnt = num[i];
				maxnum = i;
				flag = 0;
			}else if(maxcnt == num[i]) {
				if(flag == 0) {
					maxnum = i;
					flag++;
				}
			}
		}
		for(int i = 0; i < 4001; i++) {
			if(maxcnt < num[i]) {
				maxcnt = num[i];
				maxnum = i;
				flag = 0;
			}else if(maxcnt == num[i]) {
				if(flag == 0) {
					maxnum = i;
					flag++;
				}
			}
		}
		
		if(maxnum > 4000) {
			maxnum = (-1)*(maxnum - 4000);
		}
		Arrays.sort(arr);
		
		System.out.println(Math.round(sum/(double)N));
		System.out.println(arr[N/2]);
		System.out.println(maxnum);
		System.out.println(arr[N-1] - arr[0]);
	}

}
