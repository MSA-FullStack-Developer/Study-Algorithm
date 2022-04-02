public class network {

    public static void dfs(int n, boolean[] visited, int[][] computers ){
        visited[n] = true;

        for(int i = 0 ; i < computers.length ; i++){
            if(visited[i] == false && computers[n][i] == 1 && n != i){
                dfs(i, visited, computers);
            }
        }

    }
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0},{1, 1, 1},{0, 1, 1}};
        boolean[] visited = new boolean[n];
        int answer = 0;

        for(int i = 0 ; i < computers.length ; i ++){
            visited[i] = false;
        }

        for(int i = 0 ; i < computers.length ; i++){
            if(visited[i] == false){
                dfs(i, visited, computers);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
