import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1967 {

    static int n;
    static ArrayList<ArrayList<Node>> list; // 인접리스트 선언
    static int max = 0;
    static int max_node = 0;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= n + 1; i++) {
            list.add(new ArrayList<>());
        } // 리스트 내부의 리스트들을 선언한다. 이는 정점의 갯수만큼 반복한다.

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            list.get(x).add(new Node(y, num));
            list.get(y).add(new Node(x, num));
            // 정점에 연결된 노드와 가중치를 리스트에 넣어준다.
        }

        visited[1] = true;
        dfs(7, 0); // 1에서 가장 먼 노드를 찾는다.
        visited = new boolean[n + 1];
        visited[max_node] = true;
        dfs(max_node, 0);// 1에서 가장 먼 노드에서 가장 먼 노드를 찾는다.
        System.out.println(max);
    }
    // 첫번째에서 가장 먼 노드와 가중치를 저장한 후 두번째 탐색에서는 가장먼 노드에서 가장 먼 노드를 찾는다.
    // 트리 구조 특성상 가운데에서 시작해서 구하면 된다.

    public static void dfs(int r, int c) {

        if (max < c) {
            max = c;
            max_node = r;
        } // 가장 먼 노드와 가장 먼 거리를 반환한다.

        // System.out.println(r + " " + c);
        for (Node node : list.get(r)) { // r번에 연결된 num, weight을 가져온다.
            if (!visited[node.num]) { // r번에 연결된 노드 방문 여부 체크
                visited[node.num] = true;
                dfs(node.num, c + node.weight); // 연결되 노드들 탐색하면서 c에 가중치를 더해준다.
            }
        }
    }
}

class Node {
    int num;
    int weight;

    public Node(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }
}
