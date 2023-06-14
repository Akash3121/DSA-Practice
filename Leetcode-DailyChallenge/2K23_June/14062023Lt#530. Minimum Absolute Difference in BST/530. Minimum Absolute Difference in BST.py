# 530. Minimum Absolute Difference in BST

#python3
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        self.min_diff = float('inf')
        self.pre_val = None

        def dfs(root):
            if root is None: return

            dfs(root.left)

            if self.pre_val is not None:
                self.min_diff = min(self.min_diff, abs(root.val - self.pre_val))

            self.pre_val = root.val

            dfs(root.right)

        dfs(root)

        return self.min_diff