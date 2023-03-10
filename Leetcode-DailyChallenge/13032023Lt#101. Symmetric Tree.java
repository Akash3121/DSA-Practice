//101. Symmetric Tree

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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null){
            return false;
        }

        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}

#python3
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isMirror(root, root)
    
    def isMirror(self, t1, t2):
        if t1 == None and t2 == None:
            return True
        if t1 == None or t2 == None:
            return False
        
        return t1.val == t2.val and self.isMirror(t1.left, t2.right) and self.isMirror(t1.right, t2.left)

//Go
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSymmetric(root *TreeNode) bool {
    return isMirror(root, root);
}

func isMirror(t1 *TreeNode, t2 *TreeNode) bool{
    if t1 == nil && t2 == nil{
        return true;
    }
    if t1 == nil || t2 == nil{
        return false;
    }

    return t1.Val == t2.Val && isMirror(t1.Left, t2.Right) && isMirror(t1.Right, t2.Left);
}

#python3 - optimized
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def isMirror(t1, t2):
            if not t1 and not t2: return True
            if not t1 or not t2: return False
        
            return t1.val == t2.val and isMirror(t1.left, t2.right) and isMirror(t1.right, t2.left)

        return isMirror(root, root)