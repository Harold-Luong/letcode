import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class EasyLeetCode {
    private static final boolean arr1aa = false;

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

    public static String intToRoman(int number) {
        number = 1898;
        Map<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();

            while (number >= value) {
                result.append(symbol);
                number -= value;

            }
        }
        return result.toString();
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

    public static List<Integer> getListXtoY() {
        List<Integer> listxy = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            listxy.add(i);
        }
        return listxy;
    }

    public static int[] sort(int[] arr) {
        boolean swapped;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    // kra cap so cong
    public static boolean canMakeArithmeticProgression(int[] arr) {
        int[] arrNum = sort(arr);
        int d = arrNum[0] - arrNum[1];
        boolean isAP = true;
        for (int i = 0; i < arrNum.length; i++) {
            d = arrNum[i] - arrNum[i + 1];
            if (d != arrNum[0] - arrNum[1]) {
                isAP = false;
                break;
            }
        }
        return isAP;

    }

    /**
     * @param nums like {2,2,3,4,1,1,2,2}
     * @return 2
     * 
     */
    public static int majorityElement(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int value = 0;
        int key = 0;
        Map<Integer, Integer> mapArr = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int count = mapArr.getOrDefault(arr[i], 0) + 1;
            mapArr.put(arr[i], count);

            if (count > value) {
                value = count;
                key = arr[i];
            }
        }

        return key;
    }

    /**
     * An integer is a palindrome when it reads the same forward and backward.
     * 
     * For example, 121 is a palindrome while 123 is not.
     * 
     * @param x
     * @return
     * 
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        StringBuilder s = new StringBuilder();
        s.append(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
                continue;
            } else
                return false;
        }
        return true;
    }

    /**
     * 
     * @param strs = ["flower","flow","flight"]
     * @return fl
     */
    public static String longestCommonPrefix(String[] strs) {
        // if (strs.length == 1)
        // return strs[0];

        // Arrays.sort(strs);
        // for (String string : strs) {
        // System.out.println(string);
        // }
        // String s1 = strs[0];
        // String s2 = strs[strs.length - 1];
        // int idx = 0;
        // while (idx < s1.length()) {
        // if (s1.charAt(idx) == s2.charAt(idx)) {
        // idx++;
        // } else {
        // break;
        // }
        // }
        // return s1.substring(0, idx);

        // mảng rỗng
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        if (strs.length == 1) {
            return prefix;
        }

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                System.out.println(prefix);
            }
        }

        return prefix;

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // System.out.println(stack);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {

                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    /**
     * cho arr với các chữ số xuất hiện 2 lần, trong đó có 1 số xuất hiện 1
     * lần, tìm nó
     * 
     * @param nums
     * @return
     * 
     */
    public static int singleNumber(int[] nums) {

        int result = 0;
        for (int num : nums) {
            result ^= num;

        }
        return result;
    }

    // Set<Integer> set = new HashSet<>();
    // for (int num : nums) {
    // if (set.contains(num)) {
    // set.remove(num);
    // } else {
    // set.add(num);
    // }
    // }
    // return set.iterator().next();
    // }
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int r1 = 0;// tổng các phần tử trong mảng
        int r2 = (n * (n + 1)) / 2;// tổng từ 0-n
        for (int num : nums) {
            r1 += num;
        }
        // số chênh lệch là sô cần tìm
        return r2 - r1;
    }

    /**
     * Given an integer array nums, return true if any value appears at least twice
     * in the array, and return false if every element is distinct
     * 
     * @param nums arr
     * @return
     *         true or
     *         false
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(nums[i])) {
                return true;
            } else {
                map.add(nums[i]);
            }
        }
        return false;
    }

    public static int mySqrt(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int x0 = n / 2; // Đặt giá trị ban đầu x0 là nửa số cần tính căn bậc hai
        int x1 = (x0 + n / x0) / 2; // Tính giá trị x1 dựa trên x0

        while (Math.abs(x1 - x0) > 1) {
            x0 = x1;
            x1 = (x0 + n / x0) / 2;
        }

        while (x1 * x1 > n) {
            x1--;
        }

        return x1;
    }

    /**
     * Given an integer array nums and an integer val, remove all occurrences of val
     * in nums in-place. The order of the elements may be changed. Then return the
     * number of elements in nums which are not equal to val.
     * 
     * Consider the number of elements in nums which are not equal to val be k, to
     * get accepted, you need to do the following things:
     * 
     * Change the array nums such that the first k elements of nums contain the
     * elements which are not equal to val. The remaining elements of nums are not
     * important as well as the size of nums.
     * Return k.
     * 
     * @param nums
     * @param val
     * @return k
     */
    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];

            }
        }
        return j;
    }

    /**
     * Given a sorted array of distinct integers and a target value, return the
     * index if the target is found. If not, return the index where it would be if
     * it were inserted in order.
     * ex:Input: nums = [1,3,5,6], target = 2
     * Output: 1
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {

        // int i = 0;
        // if (nums[nums.length - 1] < target)
        // return nums.length;
        // while (i < nums.length) {
        // if (nums[i] == target) {
        // return i;
        // }
        // if (i > 0 && i < nums.length - 1) {
        // int previous = nums[i - 1];
        // int next = nums[i + 1];
        // if (target > previous && target < next)
        // return i + 1;
        // }
        // if (i == 0 && target > nums[0] && target < nums[i + 1]) {
        // return i + 1;
        // }
        // i++;
        // }
        // return 0;

        int right = nums.length - 1;
        int left = 0;

        while (left <= right) {
            int center = left + (right - left) / 2;
            if (nums[center] == target) {
                return center;
            } else if (nums[center] > target) {
                right = center - 1;
            } else {
                left = center + 1;
            }
        }
        return left;
    }

    /**
     * 
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        int end = digits.length - 1;
        int r = 0;
        int temp = 0;
        if (digits[end] != 9) {
            digits[end] += 1;
            return digits;
        }

        for (int i = end; i >= 0; i--) {
            if (digits[i] == 9 && i > 0) {
                digits[i] = 0;
                r = 1;
            } else if (i == 0) {
                digits[0] += 1;
                if (digits[0] > 9) {
                    digits[0] = 0;
                    temp = 1;
                }
                break;
            } else {
                digits[i] += r;
                r = 0;
                break;
            }
        }
        if (temp == 1) {
            int[] a = new int[digits.length + 1];
            a[0] = temp;
            for (int i = 0; i < digits.length - 1; i++) {
                a[i + 1] = digits[i];
            }
            return a;
        }
        return digits;

    }

    /**
     * 
     * @param digits
     * @return
     */
    public static int[] plusOne1(int[] digits) {

        int end = digits.length;
        if (digits[end - 1] != 9) {
            digits[end - 1]++;
            return digits;
        }
        for (int i = end - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        if (digits[0] == 0) {
            int[] array = new int[end + 1];
            array[0] = 1;
            return array;

        }
        return digits;

    }

    public static int reverseNumber(int x) {
        if (x == 0)
            return 0;
        String y = x + "";
        int j = 0;

        if (x > 0) {
            String[] cnum = new String[y.length()];
            for (int i = y.length() - 1; i >= 0; i--) {
                String c = y.charAt(i) + "";
                cnum[j] = c;
                j++;
            }
            String n = "";
            for (String c : cnum) {
                n += c;
            }
            try {
                int z = Integer.parseInt(n);
                return z;
            } catch (Exception e) {
                return 0;
            }

        } else {
            String[] cnum = new String[y.length() - 1];
            for (int i = y.length() - 1; i >= 1; i--) {
                String c = y.charAt(i) + "";
                cnum[j] = c;
                j++;
                if (i == 1)
                    break;
            }
            String n = "";
            for (String c : cnum) {
                n += c;
            }
            try {
                int z = Integer.parseInt(n);
                return -z;
            } catch (Exception e) {
                return 0;
            }

        }
    }

    public static void main(String[] args) {
        int x = 3;

        System.out.println(intToRoman(x));

    }

}
