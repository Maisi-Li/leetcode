/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
Subscribe to see which companies asked this question
*/


/***************My solution********************/
public class Solution {
    List<List<Integer>> res;
    List<Integer>   list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target,0);
        
        return res;
    }
    
    private void dfs(int[] nums, int target, int begin) {
        if(target == 0) {
            res.add(new ArrayList(list));
            return;
        }
        
        for(int i = begin; i < nums.length; i++) {
            if(i != begin && nums[i] == nums[i - 1]) continue;
            if(target - nums[i] < 0)
                break;
            int j = 1;
            while(target - j*nums[i] >= 0) {
                list.add(nums[i]);
                dfs(nums, target - j*nums[i], i + 1);
                j++;
            
            }
            while(j > 1) {
                list.remove(list.size() - 1);
                j--;
            }
            
        }
    }
}

/**********Better solution*************/


public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Arrays.sort(candidates); // sort the candidates
    // collect possible candidates from small to large to eliminate duplicates,
    recurse(new ArrayList<Integer>(), target, candidates, 0, ret);
    return ret;
}

// the index here means we are allowed to choose candidates from that index
private void recurse(List<Integer> list, int target, int[] candidates, int index, List<List<Integer>> ret) {
    if (target == 0) {
        ret.add(list);
        return;
    }
    for (int i = index; i < candidates.length; i++) {
        int newTarget = target - candidates[i];
        if (newTarget >= 0) {
			//!!!!!!! good
            List<Integer> copy = new ArrayList<Integer>(list);
            copy.add(candidates[i]);
            recurse(copy, newTarget, candidates, i, ret);
        } else {
            break;
        }
    }
} 