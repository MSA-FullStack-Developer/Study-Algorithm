import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p6118 {
    static int n;
    static int m;

    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int start = 1;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        arr = new int[n + 1];

        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        } // 정점의 갯수만큼 리스트를 만들어준다.

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        bfs();
        int max = 0;
        for (int s : arr) {
            if (s > max) {
                max = s;
            }
        } // 최대 거리 찾기

        int count = 0;
        for (int s : arr) {
            if (s == max) {
                count++;
            }
        } // 최대 거리값과 같은 갯수 찾기

        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int s : arr) {
            answer++;
            if (s == max) {
                list.add(answer - 1);
            }
        }
        Collections.sort(list);

        System.out.println(list.get(0) + " " + (max - 1) + " " + count);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);
        arr[1] = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int j = 0; j < list.get(temp).size(); j++) {
                int next = list.get(temp).get(j);
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    arr[next] = arr[temp] + 1;
                }
            }
        }
    }
}
// [3, 2] [3, 1, 4, 5] [6, 4, 2, 1] [3, 2] [2] [3]