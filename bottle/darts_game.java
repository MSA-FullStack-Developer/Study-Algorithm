import java.util.*;

public class darts_game {

    public static void main(String[] args) {
        String dartResult = "1S*2T*3S";
        char[] dart = dartResult.toCharArray();
        int[] round = new int[3];
        for (char c : dart) {
            System.out.print(c + " ");
        } // 문자열 한문자씩 나누기
        System.out.println(" ");
        int idx = -1;
        for (int i = 0; i < dartResult.length(); i++) {
            if (dart[i] >= '0' && dart[i] <= '9') {
                idx++;
                round[idx] += Integer.parseInt(String.valueOf(dart[i]));
                if (dart[i] == '1' && dart[i + 1] == '0') {
                    round[idx] -= Integer.parseInt(String.valueOf(dart[i]));
                    round[idx] = 10;
                    i++;
                }
            } else if (dart[i] == 'D') {
                round[idx] *= round[idx];
            } else if (dart[i] == 'T') {
                round[idx] *= (round[idx] * round[idx]);
            } else if (dart[i] == '*') {
                if (idx == 0) {
                    round[idx] = round[idx] * 2;
                } else {
                    round[idx] = round[idx] * 2;
                    round[idx - 1] = round[idx - 1] * 2;
                }
            } else if (dart[i] == '#') {
                round[idx] = round[idx] * -1;
            }
        }
        int sum = 0;
        for (int i : round) {
            sum += i;
        }
        System.out.println(sum);
    }

}
