/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/

/**************my solution************/
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
    List<String> res;
    List<Integer> list;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        list = new ArrayList<>(); 
        
        if(root == null)
            return res;
        dfs(root);
        
        return res;
    }
    
    private void dfs(TreeNode node) {
        if(node.left == null && node.right == null) {
            list.add(node.val);
            res.add(print(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(node.val);
        if(node.left != null)
            dfs(node.left);
            
        if(node.right != null)
            dfs(node.right);
        list.remove(list.size() - 1);
        return;
    }
    
    private String print(List<Integer> list) {
        String res = "";
        for(int i = 0; i < list.size() - 1; i++) {
            res = res + Integer.toString(list.get(i)) + "->";
        }
        res+= list.get(list.size() - 1);
        return res;
    }
    
}

/************better one ****************/
// do not need to use two list

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
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root != null)
            dfs(root, "");
            
        return res;
    }
    
    private void dfs(TreeNode node, String s) {
    
        if(node.left == null && node.right == null) {
            res.add(s + node.val);
            return;
        }
        
        if(node.left != null)
            dfs(node.left, s + node.val + "->");
        if(node.right != null)
            dfs(node.right, s + node.val + "->");    
        
    }
    
}