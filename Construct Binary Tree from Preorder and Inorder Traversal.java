/*
Given preorder and inorder traversal of a tree, construct the binary tree.
*/


/*********solution************/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length - 1;
        TreeNode root = build(inorder, preorder, 0, len, 0, len);
        
        return root;
    }
    
    private TreeNode build(int[] inorder, int[] preorder, int iLeft, int iRight, int pLeft, int pRight) {
        if(iLeft > iRight || pLeft > pRight)
            return null;
        TreeNode root = new TreeNode(preorder[pLeft]);
        if(iLeft == iRight)
            return root;
            
        int pos = 0;
        for(int i = iLeft; i <=iRight; i++) {
            if(inorder[i] == preorder[pLeft]) {
                pos = i;
                break;
            }
        }
        root.left = build(inorder, preorder, iLeft, pos - 1, pLeft + 1, pLeft + pos - iLeft);
        root.right = build(inorder, preorder, pos + 1, inorder.length - 1, pLeft + pos - iLeft + 1, pRight);
        return  root;
    }
}