/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []    // pay attentioin !
]
*/


/********my solution*********/
public class Solution {
    List<List<Integer>> res;
    List<Integer> list;
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        list = new ArrayList<>();
        res.add(list);
        helper(nums, 0, 0);
        
        return res;
    }
    
    private void helper(int[] nums, int len, int begin) {
        if(len == nums.length || begin == nums.length)
            return;
        
        for(int i = begin; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList(list));
            helper(nums, len + 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}


/*****************better one********/
// boundary situation
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    if(S.length == 0){
        return result;
    }

    Arrays.sort(S);
    dfs(S, 0, new ArrayList<Integer>(), result);
    return result;
}

public void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
    result.add(new ArrayList<Integer>(path));

    for(int i = index; i < s.length; i++){
        path.add(s[i]);
        dfs(s, i+1, path, result);
        path.remove(path.size()-1);
    }
}
}

