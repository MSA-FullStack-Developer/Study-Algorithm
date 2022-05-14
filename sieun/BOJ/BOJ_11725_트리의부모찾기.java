import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		arr[1] = 1;
		List<Integer>[] list = new ArrayList[N+1];
		
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		StringTokenizer st;
		for(int i = 0 ; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			list[num1].add(num2);
			list[num2].add(num1);
		}
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int idx = q.poll();
			for(int i = 0; i < list[idx].size(); i++) {
				if(!visited[list[idx].get(i)]) {
					visited[list[idx].get(i)] = true;
					q.offer(list[idx].get(i));
					arr[list[idx].get(i)] = idx;
				}
			}
		}
		for(int i = 2; i < N+1; i++) {
			System.out.println(arr[i]);
		}
	}

}
