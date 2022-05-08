import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p13023 {

    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;

    static int count = 0;
    static int depth = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        for (int a = 0; a < n; a++) {
            dfs(a, 1);
        }
        System.out.println("0");
    }

    public static void dfs(int i, int depth) {
        if (depth == 5) {
            System.out.println("1");
            System.exit(0);
        }
        visited[i] = true;
        for (int j = 0; j < list.get(i).size(); j++) {
            // 리스트의 특정 정점을 기준으로 잡아서 그 정점과 인접한 정점들을 확인해야 한다.
            // 1. 정점을 가져온다. -> i에 인접한 정점을 확인
            // list.get(i).get(j)
            int next = list.get(i).get(j);
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[i] = false;
    }
}
