public class carpet {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        int[] answer = new int[2];

        int row = 0;
        int col = 0;

        int area = brown + yellow ;
        for(int i = 1 ; i < area ; i++){
            row = i ;
            col = area / row;

            if(row < col){
                continue;
            }

            if((row-2)*(col-2)==yellow && (area/row)==0){
                answer[0] = row;
                answer[1] = col;
                break;
            }
        }

        for (int i : answer) {
            System.out.print(i+" ");
        }
    }
}
