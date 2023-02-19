/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sec=new ArrayList<>();
        Deque<TreeNode> dq=new LinkedList<>();
        if(root==null)
        {
            return sec;
        }
        dq.offer(root);
        boolean f=true;
        while(!dq.isEmpty())
        {
            List<Integer> fir=new ArrayList<>();
            int size=dq.size();
            while(size-->0)
            {
                if(f)
                {
                    TreeNode x=dq.pollLast();
                    fir.add(x.val);
                    if(x.left!=null)
                    {
                        dq.addFirst(x.left);
                    }
                    if(x.right!=null)
                    {
                        dq.addFirst(x.right);
                    }
                }
                else
                {
                    TreeNode x=dq.poll();
                    fir.add(x.val);
                    if(x.right!=null)
                    {
                        dq.offer(x.right);
                    }
                    if(x.left!=null)
                    {
                        dq.offer(x.left);
                    }
                }
            }
            f=!f;
            sec.add(new ArrayList(fir));
        }
        return sec;
    }
}
