import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;

public class p1325 {
    static int n;
    static int m;
    static int[][] check;
    static boolean[] visited;

    static int[] arr;
    static int max = 0;
    static int count = 0;
    static ArrayList<Integer> arrList[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        arr = new int[n + 1];
        arrList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            arrList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrList[x].add(y);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, arr[i]);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == max)
                sb.append(i + " ");
        }
        System.out.println(sb.toString());

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int temp = queue.poll();

            for (int j = 0; j < arrList[temp].size(); j++) {
                int v = arrList[temp].get(j);
                if (!visited[v]) {
                    visited[v] = true;
                    arr[v]++;
                    queue.add(v);
                }
            }

        }
    }

}
