import java.util.Scanner;

public class BOJ_2960_에라토스테네스의체 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N+1];
		int answer = 0;
		
		for(int i = 2; i < arr.length; i++) {
			if(arr[i] == 0) {
				for(int j = i; j < arr.length; j+=i) {
					if(arr[j] == 0) {
						arr[j] = 1;
						answer++;
					}
					if(answer == K) {
						System.out.println(j);
						return;
					}
				}
			}
		}
	}

}
