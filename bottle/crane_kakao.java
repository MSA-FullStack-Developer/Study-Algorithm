import java.util.Stack;

/* 프로그래머스 level1 크레인 뽑기 인형                                    */
/* 자료구조 : stack                                                   */
/* 1. i = 0 부터라고 가정 하였을 때 board[0][i]번째가 맨위부터 시작임을 인지한다. */
/* 2. moves 배열은 열을 의미하고 0 ~ n 번째 행의 값을 조사해야 한다.            */
/* 3. foreach문을 통하여 mov에 moves 배열을 넣고 맨 윗줄 부터 0이 나오지 않을 때 */
/*    까지 조사한다. 0이 아니면 그 값을 stack의 top과 비교하고 같지 않으면 stack  */
/*    에 넣는다. 만약 같다면 pop 하고 2개의 블럭이 사라졌기 때문에 answer에 2을 +  */
/* 4. 위의 과정이 진행 되었으면 stack에 해당 블럭이 이동된 상태이기 때문에          */
/*    그 값을 0으로 바꾸고 다음 과정을 수행한다.                               */
public class crane_kakao {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (Integer mov : moves) {
            for(int i = 0 ; i < board.length ; i++){
                if(board[i][mov-1] != 0 ){
                    if(stack.peek() == board[i][mov-1]){
                        stack.pop();
                        answer += 2;
                    }else stack.push(board[i][mov-1]);
                    board[i][mov-1] = 0;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}