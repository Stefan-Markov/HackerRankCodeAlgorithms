package BreakingTheRecords;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    public static List<Integer> breakingRecords(List<Integer> scores) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int countMax = -1;
        int countMin = -1;
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < scores.size(); i++) {
            int var = scores.get(i);

            if (var > max) {
                max = var;
                countMax++;
            }
            if (var < min) {
                min = var;
                countMin++;
            }
        }
        list.add(countMax);
        list.add(countMin);
        return list;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining(" "))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
