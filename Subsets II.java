/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

/************my solution***********/
public class Solution {
    List<List<Integer>> res;
    List<Integer> list;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0);
        
        return res;
    }
    
    private void dfs(int[] nums, int len) {
        res.add(new ArrayList(list));
        
        for(int i = len; i < nums.length; i++) {
            if(i != len && nums[i - 1] == nums[i]) continue;
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
        
    }
}