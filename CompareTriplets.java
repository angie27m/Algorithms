import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    
    static Integer pointsAlice = 0, pointsBob = 0;
   
    /*
     * The function return an the points awarded by Alice and Bob
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        IntStream.range(0, a.size()).forEach(index -> {
            //If a[i] > b[i], then Alice is awarded 1 point  and if a[i] < b[i], then Bob is awarded 1 point.
            if (a.get(index) > b.get(index)) {
                pointsAlice += 1;
            } else if (a.get(index) < b.get(index)) {
                pointsBob += 1;
            }
        });
        List<Integer> results = new ArrayList<>();
        results.add(pointsAlice);
        results.add(pointsBob);
        return results;
    }

}

public class CompareTriplets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
