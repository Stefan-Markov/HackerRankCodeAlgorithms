package BirthdayCakeCandles;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    public static int birthdayCakeCandles(List<Integer> candles) {

        Integer max = Collections.max(candles);
        return (int) candles.stream().filter(el -> el.equals(max)).count();

//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < candles.size(); i++) {
//            map.putIfAbsent(candles.get(i), 0);
//            map.put(candles.get(i), map.get(candles.get(i)) + 1);
//        }
//        return map.values().stream().mapToInt(Integer::intValue).max().getAsInt();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.birthdayCakeCandles(candles);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
