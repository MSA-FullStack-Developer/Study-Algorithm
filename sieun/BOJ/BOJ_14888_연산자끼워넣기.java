import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {

	static int N;
	static int[] operlist;
	static int[] arr;
	static boolean[] visited;
	static int[] numbers;
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		// 숫자값 받아오기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 갯수 받아오기 (+, -, x, /)
		int[] oper = new int[4];
		operlist = new int[N-1];
		numbers = new int[N-1];
		visited = new boolean[N-1];
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
			if(oper[i] > 0) {
				for(int j = 0; j < oper[i]; j++) {
					operlist[idx++] = i;
				}
			}
		}
		
		perm(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void perm(int cnt) {
		if(cnt == N-1) {
			int result = calc();
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i = 0; i < N-1; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = operlist[i];
			perm(cnt+1);
			visited[i] = false;
		}
	}
	
	private static int calc() {
		int sum = arr[0];
		for(int i = 0; i < numbers.length; i++) {
			switch (numbers[i]) {
			case 0: sum += arr[i+1]; break;
			case 1: sum -= arr[i+1]; break;
			case 2: sum *= arr[i+1]; break;
			case 3: sum = sum < 0? -1*(Math.abs(sum)/arr[i+1]): sum/arr[i+1]; break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + numbers[i]);
			}
		}
		
		return sum;
	}
}
