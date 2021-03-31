package nz.ac.aucklanduni.rfen629.problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("SpellCheckingInspection")
public class SingleNumber {

    /*
     * LeetCode 136
     * https://leetcode.com/problems/single-number/
     */
    public int singleNumber(int[] nums) {
        Set<Integer> unique = new HashSet<>();

        int uniqueSum = 0, totalSum = 0;
        for (int num : nums) {
            if (!unique.contains(num)) {
                unique.add(num);
                uniqueSum += num;
            }
            totalSum += num;
        }

        return (2 * uniqueSum - totalSum);
    }

    /*
     * LeetCode 137
     * https://leetcode.com/problems/single-number-ii/
     */
    public int singleNumber2(int[] nums) {
        Set<Integer> unique = new HashSet<>();

        long uniqueSum = 0, totalSum = 0;

        for (int num : nums) {
            if (!unique.contains(num)) {
                uniqueSum += num;
                unique.add(num);
            }

            totalSum += num;
        }

        return (int) ((3 * uniqueSum - totalSum) / 2);
    }

    /*
     * LeetCode 260
     * https://leetcode.com/problems/single-number-iii/
     */
    public int[] singleNumber3(int[] nums) {
        int sharedBits = 0;

        for (int num : nums) {
            sharedBits ^= num;
        }

        int diffAtBitFromRight = 0;
        for (int i = 0; i < 32; i++) {
            if (((sharedBits >> i) & 1) == 1) {
                diffAtBitFromRight = 1 << i;
                break;
            }
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diffAtBitFromRight) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[] {a, b};
    }

}
