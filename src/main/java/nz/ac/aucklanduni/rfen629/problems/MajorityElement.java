package nz.ac.aucklanduni.rfen629.problems;

public class MajorityElement {

    /*
     * LeetCode 169
     * https://leetcode.com/problems/majority-element/
     */
    public int majorityElement(int[] nums) {
        int currentMax = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                currentMax = nums[i];
                count++;
            } else if (currentMax == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return currentMax;
    }

}
