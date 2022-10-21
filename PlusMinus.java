import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    static double positiveCount = 0, negativeCount = 0, zerosCount = 0;
   
    /*
     * Get the proportion of positive, negative and zeros values
     */
    public static void plusMinus(List<Integer> arr) {
        arr.stream().forEach(num -> {
            if (num > 0) {
                positiveCount++;
            } else if (num == 0) {
                zerosCount++;
            } else {
                negativeCount++;
            }
        });
        //Print the results with 6 digits after the decimal
        System.out.println(String.format("%.6f",positiveCount/arr.size()));
        System.out.println(String.format("%.6f",negativeCount/arr.size()));
        System.out.println(String.format("%.6f",zerosCount/arr.size()));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}