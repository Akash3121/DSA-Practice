//129. Sum Root to Leaf Numbers

#python3
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        return self.dfs(root, 0)
    
    def dfs(self, root, sum):
        if not root:
            return 0
        
        sum = sum * 10 + root.val

        if not root.left and not root.right:
            return sum

        return self.dfs(root.left, sum) + self.dfs(root.right, sum) 

//Java
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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum){
        if (root == null){
            return 0;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null){
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}