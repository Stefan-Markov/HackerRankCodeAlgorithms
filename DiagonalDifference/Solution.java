package DiagonalDifference;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {


    public static int diagonalDifference(List<List<Integer>> arr) {

        int sumDiagonalSecond = 0;
        int col = 0;
        for (int i = 0; i < arr.size(); i++) {
            sumDiagonalSecond += arr.get(i).get(col++);
        }

        int sumDiagonalFirst = 0;
        int row = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            sumDiagonalFirst += arr.get(i).get(row++);
        }
        return Math.abs(sumDiagonalSecond - sumDiagonalFirst);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
