public class target_number {

    static int answer = 0;

    public static void dfs(int n, int tg, int[] numbers, int sum){
        if(n == numbers.length){
            if(sum == tg) answer++;
            return;
        }

        sum += numbers[n];
        dfs(n+1, tg, numbers, sum);
        sum -= numbers[n];
        sum += (numbers[n] * -1);
        dfs(n+1, tg, numbers, sum);
        
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        answer = 0;
       
        dfs(0, target, numbers, 0);
        
        System.out.println(answer);
    }
    
}
