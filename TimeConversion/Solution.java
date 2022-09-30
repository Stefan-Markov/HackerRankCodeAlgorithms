package TimeConversion;

import java.io.*;
import java.util.Objects;

class Result {
    public static String timeConversion(String s) {

        String time = s.substring(0, 8);
        String format = s.substring(8);
        String[] timeArray = time.split(":");

        if (format.equalsIgnoreCase("PM")) {
            if (!timeArray[0].equals("12")) {
                int hour = Integer.parseInt(timeArray[0]) + 12;
                timeArray[0] = String.valueOf(hour);
            }
        } else {
            if (timeArray[0].equals("12")) {
                timeArray[0] = "00";
            }
        }
        return String.join(":", timeArray);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
