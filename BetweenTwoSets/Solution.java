package BetweenTwoSets;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {


    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcm = a.get(0);
        for (Integer integer : a) {
            lcm = lcm(lcm, integer);
        }

        int gc = b.get(0);
        for (Integer integer : b) {
            gc = gcd(gc, integer);
        }

        int result = 0, multiple = 0;
        while (multiple <= gc) {
            multiple += lcm;
            if (gc % multiple == 0) {
                result++;
            }
        }
        return result;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            int gcd = gcd(a, b);
            return Math.abs((a * b) / gcd);
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);
//
//        bufferedWriter.write(String.valueOf(total));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
