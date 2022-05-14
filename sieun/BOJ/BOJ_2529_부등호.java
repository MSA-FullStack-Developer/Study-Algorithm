import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529_부등호 {

	static int k;
	static int[] numbers;
	static boolean[] visited;
	static String[] arr;
	static List<String> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new String[k];
		numbers = new int[k+1];
		visited = new boolean[10];
		list = new ArrayList<String>();
		
		for(int i = 0; i < k; i++) {
			arr[i] = st.nextToken();
		}
		
		perm(0);
		
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
	
	private static void perm(int cnt) {
		if(cnt == k+1) {
			for(int i = 0; i < arr.length; i++) {
				if(arr[i].equals("<")) {
					if(numbers[i] >= numbers[i+1]) return;
				}else {
					if(numbers[i] <= numbers[i+1]) return;
				}
			}
			
			String str = "";
			for(int i = 0; i < numbers.length; i++) {
				str += numbers[i];
			}
			list.add(str);
			
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = i;
			perm(cnt+1);
			visited[i] = false;
		}
	}

}
