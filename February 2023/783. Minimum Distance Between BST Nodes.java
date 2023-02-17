/*
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

 

Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 100].
0 <= Node.val <= 105
 

Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
*/

public class Solution {
    // **** keep track of state in recursive call (part of the solution) ****
    static int  minDiff = 0;
    static int  prevVal = Integer.MAX_VALUE;


    /**
     * Given a Binary Search Tree (BST) with the root node root, 
     * return the minimum difference between the values of any 
     * two different nodes in the tree.
     * This function implements the solution.
     */
    static int minDiffInBST(TreeNode root) {
        
        // **** initialization ****
        minDiff = Integer.MAX_VALUE;
        prevVal = Integer.MIN_VALUE;

        // **** recursive call ****
        minDiffTraversal(root);

        // **** return result ****
        return minDiff;
    }


    /**
     * Look for the minimum difference between any two node values.
     * Based on in-order traversal.
     * This is a recursive function.
     * This function is pasrt of the solution.
     */
    static void minDiffTraversal(TreeNode root) {

        // **** base case ****
        if (root == null)
            return;

        // **** visit left tree ****
        minDiffTraversal(root.left);

        // **** update the minimum difference (if needed) ****
        if (prevVal != Integer.MIN_VALUE) {
            int diff = root.val - prevVal;
            if (diff < minDiff)
                minDiff = diff;
        }

        // **** update the previous value ****
        prevVal = root.val;

        // **** visit right tree ****
        minDiffTraversal(root.right);
    }


    /**
     * This function populates a BST in level order as 
     * specified by the array.
     * This function supports 'null' values.
     */
    static TreeNode populateTree(String[] arr) {
    
        // **** root for the BT ****
        TreeNode root = null;
    
        // **** auxiliary queue ****
        Queue<TreeNode> q = new LinkedList<TreeNode>();
    
        // **** traverse the array of values inserting nodes 
        //      one at a time into the BST ****
        for (String strVal : arr)
            root = insertValue(root, strVal, q);
    
        // **** clear the queue (the garbage collector will do this) ****
        q = null;
    
        // **** return the root of the BST ****
        return root;
    }


    /**
     * Enumerate which child in the node at the head of the queue 
     * (see populateTree function) should be updated.
     */
    enum Child {
        LEFT,
        RIGHT
    }


    // **** child turn to insert on node at head of queue ****
    static Child  insertChild = Child.LEFT;


    /**
     * This function inserts the next value into the specified BST.
     * This function is called repeatedly from the populateTree method.
     * This function supports 'null' value.
     */
    static TreeNode insertValue(TreeNode root, String strVal, Queue<TreeNode> q) {
    
        // **** node to add to the BST in this pass ****
        TreeNode node = null;
    
        // **** create a node (if needed) ****
        if (!strVal.equals("null"))
            node = new TreeNode(Integer.parseInt(strVal));
    
        // **** check is the BST is empty (this becomes the root node) ****
        if (root == null)
            root = node;
    
        // **** add node to left child (if possible) ****
        else if (insertChild == Child.LEFT) {
        
            // **** add this node as the left child ****
            if (node != null)
                q.peek().left = node; 
            
            // **** for next pass ****
            insertChild = Child.RIGHT;
        }
    
        // **** add node to right child (if possible) ****
        else if (insertChild == Child.RIGHT) {
        
            // **** add this node as a right child ****
            if (node != null)
                q.peek().right = node;
    
            // **** remove node from queue ****
            q.remove();
    
            // **** for next pass ****
            insertChild = Child.LEFT;
        }
    
        // **** add this node to the queue (if NOT null) ****
        if (node != null)
            q.add(node);
        
        // **** return the root of the BST ****
        return root;
    }


    /**
     * Traverse the specified BST displaying the values in order.
     * This method is used to verify that the BST was properly populated.
     */
    static void inOrder(TreeNode root) {
    
        // **** end condition ****
        if (root == null)
            return;
    
        // **** visit the left sub tree ****
        inOrder(root.left);
    
        // **** display the value of this node ****
        System.out.print(root.val + " ");
    
        // **** visit the right sub tree ****
        inOrder(root.right);
    }


    /**
     * Test scaffolding.
     */
    public static void main(String[] args) {
        
        // **** root of BST ****
        TreeNode root = null;

        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read into a string array the node values for the BST ****
        String[] arr = sc.nextLine().split(",");

        // **** close scanner ****
        sc.close();

        // **** populate the BST in level order ****
        root = populateTree(arr);
System.out.print("main <<< inOrder: ");
        inOrder(root);
        System.out.println();

        // **** compute and display the minimum difference between node values ****
        System.out.println("main <<< minDiffInBST: " + minDiffInBST(root));
    }
    
}
