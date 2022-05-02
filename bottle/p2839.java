import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p2839 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 2000; i++) {
            for (int j = 0; j <= 1000; j++) {
                if (3 * i + 5 * j == N) {
                    list.add(i + j);
                }
            }
        }
        Collections.sort(list);
        if (list.isEmpty()) {
            System.out.println("-1");
        } else {
            System.out.println(list.get(0));
        }
    }
}
