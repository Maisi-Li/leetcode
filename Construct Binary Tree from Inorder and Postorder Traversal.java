/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Subscribe to see which companies asked this question
*/


/**
http://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/
in-order:   4 2 5  (1)  6 7 3 8
post-order: 4 5 2  6 7 8 3  (1)
**/

/*********my solution********/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLeft = 0; 
        int inRight = inorder.length - 1;
        int postLeft = 0 ;
        int postRight = postorder.length - 1;
         
        return buildTree(inorder, inLeft, inRight, postorder, postLeft, postRight);
    }
    
    private TreeNode buildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if(inRight < inLeft || postRight < postLeft)
            return null;
        // set root 
        TreeNode root = null;
        if(inRight >= inLeft)
            root = new TreeNode(postorder[postRight]);
            
        if(inRight == inLeft)
            return root;
            
        // find root position in inorder array
        int rootPos = 0;
        for(int i = inLeft; i <= inRight; i++) {
            if(inorder[i] == postorder[postRight]) {
                rootPos = i;
                break;
            }
        }
        // link left and right
        if(rootPos > 0)
            root.left = buildTree(inorder, inLeft, rootPos - 1, postorder, postLeft, postLeft + rootPos - (inLeft + 1));
            
        if(rootPos < inorder.length - 1)   
            root.right = buildTree(inorder, rootPos + 1, inRight, postorder, postLeft + rootPos - inLeft, postRight - 1);
            
        // return root
        return root;
    }
}