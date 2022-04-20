
public class ternary_numeral {

    public static void main(String[] args) {
        int n = 125;

        String ternary = "";
        String s = "";
        while (true) {
            if (n < 3) {
                ternary = n + ternary;
                break;
            }
            s = String.valueOf(n % 3);
            ternary = s + ternary;
            n = n / 3;
        }
        System.out.println(ternary);
        String b_ternary = "";

        for (int i = 0; i < ternary.length(); i++) {
            String c1 = ternary.substring(i, i + 1);
            b_ternary = c1 + b_ternary;
        }
        System.out.println(b_ternary);
        int sum = 0;
        int k = 0;
        int m = b_ternary.length() - 1;

        while (true) {
            String c2 = b_ternary.substring(k, k + 1);
            System.out.print(c2 + "");
            int a = Integer.parseInt(c2) * (int) (Math.pow(3, m));
            k++;
            m--;
            sum += a;
            if (m < 0) {
                break;
            }
        }
        System.out.println(sum);
    }
}
