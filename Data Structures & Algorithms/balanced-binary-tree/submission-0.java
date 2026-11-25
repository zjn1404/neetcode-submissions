/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int lH = height(root.left);
        int rH = height(root.right);
        if (Math.abs(lH - rH) > 1) isBalanced = false;

        return Math.max(lH, rH) + 1;
    }
}