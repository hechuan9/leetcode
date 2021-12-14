class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        def preorder(node, currSum):
            nonlocal count

            if node == None: return
            currSum += node.val
            if currSum == targetSum:
                count += 1
            if cache[currSum - targetSum]:
                count += cache[currSum - targetSum]
            cache[currSum] += 1
            preorder(node.left, currSum)
            preorder(node.right, currSum)
            cache[currSum] -= 1

        count = 0
        cache = defaultdict(int)
        preorder(root, 0)
        return count
