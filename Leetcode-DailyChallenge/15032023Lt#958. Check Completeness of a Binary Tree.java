//958. Check Completeness of a Binary Tree

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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null){
            return false;
        }

        //creating queue - storing root
        Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));

        while(q.peek() != null){
            TreeNode node = q.poll();
            q.offer(node.left);
            q.offer(node.right);
        }

        //removing null nodes 
        while(!q.isEmpty() && q.peek() == null){
            q.poll();
        }

        return q.isEmpty();
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
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        if not root: return True

        flag = False
        q = [root]

        while q:
            node = q.pop(0)

            if node is None:
                flag = True
                continue #first time
            
            if flag: #if num is b/w None
                return False
            
            q.append(node.left)
            q.append(node.right)
        
        return True