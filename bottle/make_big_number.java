public class make_big_number {
    public static void main(String[] args) {
        // 4177252841
        // 77 5 841

        // 1231234
        // 3 234
        String number = "4177252841";
        int k = 4;
        int now = 0;
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int j = now; j <= i + k; j++) {
                int tmp_num = number.charAt(j) - '0';
                if (max < tmp_num) {
                    idx = j;
                    max = tmp_num;
                }
            }
            sb.append(max);
            now = idx + 1;
        }
        answer = sb.toString();
        System.out.println(answer);
    }
}
