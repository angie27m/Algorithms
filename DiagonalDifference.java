import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    
    static int primaryDiagonal = 0, secondaryDiagonal;
    
    /*
     * Calculate te absolute value of square matrix
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        
        for (int i=0; i<arr.size(); i++) {
            for (int j=0; j<arr.size(); j++) {
                // Get the primary diagonal
                if (i == j) {
                    primaryDiagonal += arr.get(i).get(j);
                }
                // Get the secondary diagonal
                if(i+j == arr.size()-1) {
                    secondaryDiagonal += arr.get(i).get(j);
                }
            }  
        }
        //Get absolute value
        return Math.abs(primaryDiagonal-secondaryDiagonal);
    }

}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}