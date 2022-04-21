package hash;

import java.util.*;

public class p1920 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = scan.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scan.nextInt();
        }

        int m = scan.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scan.nextInt();
        }

        for (int i : arr1) {
            hashMap.put(i, 0);
        }

        int[] answer = new int[arr2.length];
        for (int i = 0; i < arr2.length; i++) {
            if (hashMap.containsKey(arr2[i])) {
                answer[i] = 1;
            } else
                answer[i] = 0;
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
