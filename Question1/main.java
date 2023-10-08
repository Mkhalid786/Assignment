import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        // A. Create an array with the values (1, 2, 3, 4, 5, 6, 7) and shuffle it.
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> numberList = Arrays.asList(numbers);
        Collections.shuffle(numberList);
        System.out.println("Shuffled array: " + numberList);

        // B. Enter a Roman Number as input and convert it to an integer .
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine().toUpperCase();
        int romanToInteger = romanToInteger(romanNumeral);
        System.out.println("Integer representation: " + romanToInteger);

        // C. Check if the input is a pangram or not.
        System.out.print("Enter a sentence to check if it's a pangram: ");
        String inputSentence = scanner.nextLine().toLowerCase();
        boolean isPangram = isPangram(inputSentence);
        if (isPangram) {
            System.out.println("The input is a pangram.");
        } else {
            System.out.println("The input is not a pangram.");
        }
    }

    // Helper function to convert a Roman numeral to an integer
    public static int romanToInteger(String s) {
        // Define the values of Roman numerals
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int result = 0;
        int i = 0;

        while (i < s.length()) {
            for (int j = 0; j < numerals.length; j++) {
                if (s.startsWith(numerals[j], i)) {
                    result += values[j];
                    i += numerals[j].length();
                    break;
                }
            }
        }

        return result;
    }

    // Helper function to check if a sentence is a pangram
    public static boolean isPangram(String s) {
        boolean[] alphabetPresent = new boolean[26];

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                alphabetPresent[c - 'a'] = true;
            }
        }

        for (boolean present : alphabetPresent) {
            if (!present) {
                return false;
            }
        }

        return true;
    }
}
