
import java.io.*;
import java.util.*;
// It has all the constraints/Boundrary cases which can be there in tme conversion format 
// Code copied from HackerRank.
public class HourClockFormat {

    static String timeConversion(String s) {
        String t1 = s;
        String t2;;
        if (t1.equals("12:00:00AM")) {   // Constraint1 
            return "00:00:00";
        } else if (t1.charAt(8) == 'A') {
            String hour = t1.substring(0, 2);
            int Hour = Integer.parseInt(hour);
            if (Hour == 12) {                       //Constraint2
                return "00" + t1.substring(2, 8);   
            } else {
                t2 = t1.substring(0, 8);
                return t2;
            }
        } else if (t1.charAt(8) == 'P') {

            String hour = t1.substring(0, 2);
            int Hour = Integer.parseInt(hour);
            if (Hour == 12) {                       //Constraint3
                Hour = 12;
            } else {
                Hour += 12;
            }
            return Hour + t1.substring(2, 8);
        } else {
            return "null";
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
