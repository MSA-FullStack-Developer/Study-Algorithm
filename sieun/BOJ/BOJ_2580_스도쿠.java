import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
	
	static int[][] arr = new int[9][9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		back(0, 0);
	}
	
	private static void back(int r, int c) {
		if(c == 9) {
			back(r+1, 0);
			return;
		}
		if(r == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		if(arr[r][c] == 0) {
			for(int i = 1; i < 10; i++) {
				if(check(r, c, i)) {
					arr[r][c] = i;
					back(r, c+1);
				}
			}
			arr[r][c] = 0;
			return;
		}else {
			back(r, c+1);
		}
	}
	
	public static boolean check(int row, int col, int value) {
        int baseRow=(row/3)*3;
        int baseCol=(col/3)*3;

        for(int i=0; i<9; i++) {
            if(value==arr[row][i]) return false;
            if(value==arr[i][col]) return false;
        }

        for(int i=baseRow; i<baseRow+3; i++) {
            for(int j=baseCol; j<baseCol+3; j++) {
                if(value==arr[i][j]) return false;
            }
        }

        return true;
    }


}