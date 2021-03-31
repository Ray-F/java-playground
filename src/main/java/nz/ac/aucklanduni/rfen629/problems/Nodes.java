package nz.ac.aucklanduni.rfen629.problems;

import java.util.Arrays;

public class Nodes {

    /*
     * For LeetCode 104
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            this(100);
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
     * LeetCode 104
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.right != null) {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        } else if (root.left != null) {
            return 1 + maxDepth(root.left);
        } else if (root.right != null) {
            return 1 + maxDepth(root.right);
        } else {
            return 1;
        }
    }



    /*
     * LeetCode 108
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int rootIndex = nums.length / 2;

        TreeNode newNode = new TreeNode(nums[rootIndex]);

        int[] leftNums = Arrays.copyOfRange(nums, 0, rootIndex);
        newNode.left = sortedArrayToBST(leftNums);

        if (rootIndex + 1 != nums.length) {
            int[] rightNums = Arrays.copyOfRange(nums, rootIndex + 1, nums.length);
            newNode.right = sortedArrayToBST(rightNums);
        }

        return newNode;
    }

    /*
     * For LeetCode 237
     */
    public static class ListNode {
        public int val;

        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
     * LeetCode 237
     * https://leetcode.com/problems/delete-node-in-a-linked-list/
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /*
     * LeetCode 206
     * https://leetcode.com/problems/reverse-linked-list/
     */
    public ListNode reverseListWorking(ListNode head) {
        ListNode previousHead = null;
        ListNode currentHead = head;

        while (currentHead != null) {
            ListNode temp = currentHead.next;
            currentHead.next = previousHead;
            previousHead = currentHead;
            currentHead = temp;
        }

        return previousHead;
    }

    /*
     * LeetCode 206
     * https://leetcode.com/problems/reverse-linked-list/
     */
    public ListNode reverseList(ListNode head) {
        // If the next node is null, it means this is final node and we can just go ahead and return it
        if (head.next == null) {
            return head;
        }

        // This is the next node to process, which will eventually return the root head.
        ListNode next = reverseList(head.next);

        // Set the next head to be the current head (after it has been recused)
        head.next.next = head;

        // Set the next node of my current to be unset
        head.next = null;
        return next;
    }

}
