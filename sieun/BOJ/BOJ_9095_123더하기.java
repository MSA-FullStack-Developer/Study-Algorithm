import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* DP */
public class BOJ_9095_123더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			int[] d = new int[num+1];
			if(num <= 1) d[1] = 1;
			else if(num <= 2) {d[1] =1; d[2] = 2;}
			else {d[1] = 1; d[2] = 2; d[3] = 4;}
				
			for(int j = 4; j <= num; j++) {
				d[j] = d[j-1] + d[j-2] + d[j-3];
			}
			
			System.out.println(d[num]);
		}
		
	}

}
