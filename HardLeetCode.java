
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class HardLeetCode {

    static final Map<Integer, String> map = new LinkedHashMap<>();
    static {
        map.put(1000000000, "Billion");
        map.put(1000000, "Million");
        map.put(1000, "Thousand");
        map.put(100, "Hundred");
        map.put(90, "Ninety");
        map.put(80, "Eighty");
        map.put(70, "Seventy");
        map.put(60, "Sixty");
        map.put(50, "Fifty");
        map.put(40, "Forty");
        map.put(30, "Thirty");
        map.put(20, "Twenty");
        map.put(19, "Nineteen");
        map.put(18, "Eighteen");
        map.put(17, "Seventeen");
        map.put(16, "Sixteen");
        map.put(15, "Fifteen");
        map.put(14, "Fourteen");
        map.put(13, "Thirteen");
        map.put(12, "Twelve");
        map.put(11, "Eleven");
        map.put(10, "Ten");
        map.put(9, "Nine");
        map.put(8, "Eight");
        map.put(7, "Seven");
        map.put(6, "Six");
        map.put(5, "Five");
        map.put(4, "Four");
        map.put(3, "Three");
        map.put(2, "Two");
        map.put(1, "One");
    }

    /**
     * <ul>
     * <li>Convert a non-negative integer num to its English words
     * representation.</li>
     * 
     * <li>Link: https://leetcode.com/problems/integer-to-english-words</li>
     * </ul>
     * 
     * @param num (e.g: 123456)
     * @return "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty
     *         Seven"
     */
    public static String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        StringBuilder wBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            String valueWord = entry.getValue() + " ";
            if (num >= key) {
                if (num < 100) {
                    if (num == key) {
                        wBuilder.append(map.get(num));
                        return wBuilder.toString().trim();
                    } else {
                        int remainder = num % key;
                        wBuilder.append(valueWord);
                        num = remainder;
                    }
                } else {
                    if (num >= key) {
                        int quotient = num / key;
                        int remainder = num % key;
                        wBuilder.append(numberToWords(quotient) + " ");
                        wBuilder.append(map.get(key) + " ");
                        if (remainder > 0)
                            wBuilder.append(numberToWords(remainder));
                        return wBuilder.toString().trim();
                    }
                }
            }
        }
        return wBuilder.toString().trim();
    }

    /**
     * <ul>
     * <li>Given two sorted arrays nums1 and nums2 of size m and n respectively,
     * return
     * the median of the two sorted arrays.</li>
     * 
     * <li>The overall run time complexity should be O(log (m+n)).</li>
     * 
     * <li>https://leetcode.com/problems/median-of-two-sorted-arrays</li>
     * </ul>
     * 
     * @param nums1
     * @param nums2
     * @return median
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int l = n1 + n2;
        int[] merged = new int[l];
        // check arr null
        if (n1 == 0 || n2 == 0) {
            merged = (n1 == 0) ? nums2 : nums1;
        } else {
            int i = 0, j = 0, k = 0;
            // n1 = n2
            while (i < n1 && j < n2) {
                if (nums1[i] < nums2[j]) {
                    merged[k] = nums1[i];
                    k++;

                    i++;
                } else {
                    merged[k] = nums2[j];
                    k++;

                    j++;
                }
            }

            while (j < n2) {
                merged[k] = nums2[j];
                k++;
                j++;
            }

            while (i < n1) {
                merged[k] = nums1[i];
                k++;
                i++;
            }
        }
        System.out.println(Arrays.toString(merged));
        if (l % 2 != 0) {
            return merged[l / 2];
        } else {
            int a = merged[(l - 2) / 2];
            int b = merged[(l / 2)];
            float mid = (float) (a + b) / 2;
            return mid;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = { 1, 2 };
        int[] nums2 = { 0, 8, 12, 15, 19 };
        // 1 2 3 4 6 8
        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2));

    }

}
