package MiniMaxSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    public static void miniMaxSum(List<Integer> arr) {
        int i;
        long sum1 = 0;
        long sum2 = 0;
        Collections.sort(arr);

        for (i = 0; i < 4; i++) {
            sum1 = sum1 + arr.get(i);
        }
        for (i = 1; i < 5; i++) {
            sum2 = sum2 + arr.get(i);
        }
        System.out.print(sum1 + " " + sum2);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
