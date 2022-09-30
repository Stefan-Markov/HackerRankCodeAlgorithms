package AbsolutePermutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    public static List<Integer> absolutePermutation(int n, int k) {

        final List<Integer> ans = new ArrayList<>(n);
        final List<Integer> no = new ArrayList<>();
        no.add(-1);
        final List<Integer> ok = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            ok.add(i + 1);
        }
        for (int i = 0; i < n; i++) {
            int first = (i + 1 + k);
            int second = (i + 1 - k);

            if (second >= 1 && second <= n && ok.get(second - 1) != -1) {
                ans.add(second);
                ok.set(second - 1, -1);
            } else if (first >= 1 && first <= n && ok.get(first - 1) != -1) {
                ans.add(first);
                ok.set(first - 1, -1);
            } else {
                return no;
            }
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = Result.absolutePermutation(n, k);

//                bufferedWriter.write(
//                        result.stream()
//                                .map(Object::toString)
//                                .collect(joining(" "))
//                                + "\n"
//                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
