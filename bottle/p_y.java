public class p_y {
    public static void main(String[] args) {
        String s = "Pyy";
        boolean answer = true;
        String c = " ";
        int p_count = 0;
        int y_count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            c = s.substring(i, i+1);
            if(c.equals("p")|| c.equals("P")){
                p_count++;
            }else if(c.equals("y") || c.equals("Y")){
                y_count++;
            }
        }

        if(p_count == y_count){
            System.out.println("true");
        }else System.out.println("false");
    }
}
