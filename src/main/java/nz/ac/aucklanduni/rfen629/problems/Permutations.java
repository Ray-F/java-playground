package nz.ac.aucklanduni.rfen629.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * @author Raymond Feng (raymond@fundafuture.co.nz)
 */
public class Permutations {

    /*
     * LeetCode 46
     * https://leetcode.com/problems/permutations/
     */
    public List<List<Object>> permuteAsObject(Object[] nums) {
        Set<List<Object>> list = new HashSet<>();
        re(list, nums, 0);
        return new ArrayList<>(list);
    }

    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        reInt(list, nums, 0);
        return new ArrayList<>(list);
    }

    private void reInt(Set<List<Integer>> current, int[] next, int index) {
        // If this is the final index
        if (index == next.length - 1) {
            List<Integer> val = new ArrayList<>();
            for (int j : next) {
                val.add(j);
            }
            current.add(val);
        } else {
            for (int i = index; i < next.length; i++) {
                int[] list = Arrays.copyOf(next, next.length);

                // Switch the box
                int temp = list[index];
                list[index] = next[i];
                list[i] = temp;

                reInt(current, list, index + 1);
            }
        }
    }

    private void re(Set<List<Object>> current, Object[] next, int index) {
        // If this is the final index
        if (index == next.length - 1) {
            List<Object> val = new ArrayList<>();
            for (Object j : next) {
                val.add(j);
            }
            current.add(val);
        } else {
            for (int i = index; i < next.length; i++) {
                Object[] list = Arrays.copyOf(next, next.length);

                // Switch the box
                Object temp = list[index];
                list[index] = next[i];
                list[i] = temp;

                re(current, list, index + 1);
            }
        }
    }
}
