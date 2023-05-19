import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {
    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
     * and M.
     * Symbol Value
     * I 1
     * V 5
     * X 10
     * L 50
     * C 100
     * D 500
     * M 1000
     * 
     * s = "MCMXCIV" = 1994
     * s = "LVIII" = 58
     */
    public static int romanToInteger(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int i = s.length() - 1;
        int total = 0;
        int prevValue = 0;
        while (i >= 0) {
            int curent = romanValues.get(s.charAt(i));
            if (curent >= prevValue) {
                total += curent;

            } else {
                total -= curent;
            }
            prevValue = curent;
            i--;
        }
        return total;
    }

    public static int numberOfSteps(int num) {
        int temp = num;
        int count = 0;

        while (temp > 0) {
            if (temp % 2 == 0) {
                temp = temp / 2;
                count++;
            } else {
                temp--;
                count++;
            }

        }
        return count;
    }

    public static List<String> fizzBuzz(int n) {
        List<String> fb = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;
            boolean divisibleBy15 = i % 15 == 0;
            if (divisibleBy15) {
                fb.add("FizzBuzz");
            } else if (divisibleBy3) {
                fb.add("Fizz");
            } else if (divisibleBy5) {
                fb.add("Buzz");
            } else {
                fb.add(String.valueOf(i));
            }
        }
        return fb;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;

        int[] charCount = new int[26];

        // Count the frequency of each character in magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Check if ransomNote can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false;
            }
            charCount[c - 'a']--;
        }

        return true;

    }

    public static void main(String[] args) {
        // Gọi hàm để đo thời gian chạy
        long startTime = System.currentTimeMillis();

        // Gọi hàm cần đo thời gian chạy ở đây
        System.out.println(canConstruct("ll", "hello"));

        // Tính thời gian chạy
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // In ra thời gian chạy
        System.out.println("Thời gian chạy: " + executionTime + "ms");

    }
}
