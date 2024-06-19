import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Method to convert an integer to a Roman numeral
    public static String intToRoman(int num) {
        // Arrays to hold the Roman numerals and their corresponding values
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // StringBuilder to build the result Roman numeral
        StringBuilder result = new StringBuilder();

        // Loop through the values and their corresponding Roman numerals
        for (int i = 0; i < values.length; i++) {
            // Append the Roman numeral as many times as the value fits into the number
            while (num >= values[i]) {
                result.append(romanNumerals[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    public static int romanToInt(String s) {
        // Map to hold the Roman numeral characters and their corresponding values
        Map<Character, Integer> romanToValue = new HashMap<>();
        romanToValue.put('I', 1);
        romanToValue.put('V', 5);
        romanToValue.put('X', 10);
        romanToValue.put('L', 50);
        romanToValue.put('C', 100);
        romanToValue.put('D', 500);
        romanToValue.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // Loop through the characters of the string
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanToValue.get(currentChar);

            // If the current value is less than the previous value, subtract it from the result
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                // Otherwise, add it to the result
                result += currentValue;
            }
            prevValue = currentValue;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Input R and Press Enter to");
        System.out.println("Convert to Roman Numeral");
        System.out.println("Else input N: ");

        Scanner scanOpp = new Scanner(System.in);
        String opp = scanOpp.nextLine();


        if (opp.equals("R") || opp.equals("r")) {
            System.out.print("Input a number: ");
            Scanner scanInput = new Scanner(System.in);
            int num = scanInput.nextInt();
            System.out.println(num + " to roman numeral is " + intToRoman(num));
        } else if (opp.equals("N") || opp.equals("n")) {
            System.out.print("Input the roman numeral: ");
            Scanner scanRInput = new Scanner(System.in);
            String rInput = scanRInput.nextLine();
            System.out.println(rInput + " to number is " + romanToInt(rInput));
        }

        System.out.println("Do you want to try again (Y/N): ");
        Scanner scanTry = new Scanner(System.in);
        String tryAgain = scanTry.nextLine();
        if (tryAgain.equals("Y") || tryAgain.equals("y")) {
            String[] call = {"call"};
            Main.main(call);
        } else {
            System.out.println("Goodbye!");
        }
    }

}