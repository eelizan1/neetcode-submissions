# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.num_good_nodes = 0

    def goodNodes(self, root: TreeNode) -> int:
        self.dfs(root, root.val)
        return self.num_good_nodes
    
    def dfs(self, node: TreeNode, maxVal: int): 
        if not node: 
            return
        
        if node.val >= maxVal: 
            self.num_good_nodes += 1
            maxVal = node.val  # <-- Fix: update maxVal, not creating new max_val
        
        self.dfs(node.left, maxVal)
        self.dfs(node.right, maxVal)
