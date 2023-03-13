/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?

Link : https://leetcode.com/problems/symmetric-tree/submissions/
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return checkSymmetric(root.left,root.right);
    }
    public boolean checkSymmetric(TreeNode leftNode,TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }
        if(leftNode == null ^ rightNode == null){
            return false;
        }
        if(leftNode.val != rightNode.val){
            return false;
        }
        return checkSymmetric(leftNode.left,rightNode.right) && checkSymmetric(leftNode.right,rightNode.left);

    }
}
