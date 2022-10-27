import java.io.*;

class Result {
    static String symbols = "";
    static String spaces = "";
    static int count = 0;
    
    /*
     * Printing staircase using "#" and spaces to right align
     */
    public static void staircase(int n) {
        count = n-1;
        for(int i=0; i<n; i++){
            for(int j=count; j>0; j--) {
                spaces += " ";                
            }
            count--;
            symbols += "#";
            System.out.println(spaces+symbols);
            spaces = "";
        }

    }

}

public class Staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}

