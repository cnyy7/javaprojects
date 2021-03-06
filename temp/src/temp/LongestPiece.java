package temp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestPiece {
    static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    public static void main(String args[]) {
        if (args == null || args.length == 0) {
            System.out.println("No data has been input.");
            return;
        }
        for (String num : args) {
            if (!isNumeric(num)) {
                System.out.println("Illegal digital format: " + num + "\n");
                continue;
            }
            int n = Integer.valueOf(num);
            String b = Integer.toBinaryString(n);
            System.out.println("The binary sequence of " + num + " is " + b);
            int count0 = 0, count1 = 0, max0 = 0, max1 = 0;
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == '0') {
                    count0++;
                    count1 = 0;
                } else {
                    count1++;
                    count0 = 0;
                }
                max0 = max0 > count0 ? max0 : count0;
                max1 = max1 > count1 ? max1 : count1;
            }
            System.out.println("The maximum length of consecutive '0' strings in the binary sequence is " + max0);
            System.out.println("The maximum length of consecutive '1' strings in the binary sequence is " + max1);
            System.out.print("\n");
        }
    }
}
