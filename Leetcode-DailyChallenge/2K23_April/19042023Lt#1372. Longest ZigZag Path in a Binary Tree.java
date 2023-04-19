//1372. Longest ZigZag Path in a Binary Tree

# python3
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            if not node:
                return [-1, -1, -1]
            left_subtree, right_subtree = dfs(node.left), dfs(node.right)
            return [
                left_subtree[1] + 1,
                right_subtree[0]+ 1,
                max(left_subtree[1] + 1, right_subtree[0] + 1, left_subtree[2], right_subtree[2])
            ]
        return dfs(root)[-1]

// Java
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
    public int longestZigZag(TreeNode root) {
        int[] res =  dfs(root);
        return res[2];
    }

    public int[] dfs(TreeNode node){
        if (node == null){
            return new int[]{-1, -1, -1};
        }

        int[] left_subtree = dfs(node.left);
        int[] right_subtree = dfs(node.right);

        int leftLength = left_subtree[1] + 1;
        int rightLength = right_subtree[0] + 1;
        int maxLength = Math.max(Math.max(leftLength, rightLength), Math.max(left_subtree[2], right_subtree[2]));

        return new int[]{leftLength, rightLength, maxLength};
    }
}