import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    static List<Integer> sumList = new ArrayList<>();
    static int sum = 0;
    
    /*
     * Get the minimum and maximum values between numbers of list 
     */
    public static void miniMaxSum(List<Integer> arr) {
        // Sum of the numbers of list
        arr.stream().forEach(number -> {
            sum += number; 
        }); 
        // Sum of number without the number equals to the index position
        for (int i=0; i<arr.size(); i++) {
            sumList.add(sum - arr.get(i));  
        }
        System.out.println(sumList.stream().max(Comparator.reverseOrder()).get()+" "
           +sumList.stream().max(Integer::compare).get());
    }

}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
