class Solution {
    
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
            visited = new boolean[words.length];
            dfs(begin, target, words, 0);
            return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, int c){
        if(begin.equals(target)){
            answer = c;
            return;
        }
        
        char[][] words_to_char = new char[words.length][words[0].length()];
        for(int i = 0 ; i < words.length ; i++){
            if(visited[i]){
                continue;
            }
            
            int count = 0;
            for(int j = 0 ; j < words[0].length() ; j++){
                words_to_char[i][j] = words[i].charAt(j);
                if(begin.charAt(j) == words_to_char[i][j]){
                    count++;
                }
            }
            
            if(count == begin.length() - 1){
                visited[i] = true;
                dfs(words[i], target, words, c + 1);
                visited[i] = false;
            }
        }
    }
}