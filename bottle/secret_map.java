import java.util.ArrayList;

public class secret_map {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] binaryarr1 = new String[n];
        String[] binaryarr2 = new String[n];
        
        String[] answer = new String[n];
        String str = "";

        for(int i = 0 ; i < n; i++){
            binaryarr1[i] = Integer.toBinaryString(arr1[i]);
            while(binaryarr1[i].length() < n){
                binaryarr1[i] = "0" + binaryarr1[i];   
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            binaryarr2[i] = Integer.toBinaryString(arr2[i]);
            while(binaryarr2[i].length() < n){
                binaryarr2[i] = "0" + binaryarr2[i];   
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(binaryarr1[i].charAt(j) == '1' || binaryarr2[i].charAt(j) == '1'){
                    str = str + "#";
                }else str = str + " ";
            }
            answer[i] = str;
            str =" ";
            System.out.print(answer[i]+ " ");
        }
    }
}