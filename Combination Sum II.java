/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

/*
use dfs method 
!!use one smart line to avoid duplicate checking 
*/
/***************My solution****************/
public class Solution {
    private List<List<Integer>> res;
    private List<Integer> list;
        
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        res = new ArrayList<>();
        Arrays.sort(candidates);
        list = new ArrayList<>();
        
        helper(candidates, 0, 0, target);
        
        return res;
        
    }
    
    void helper(int[] candidates,int begin, int sum, int target) {
        
        for(int i = begin; i < candidates.length; i++) {
            if(i > begin && candidates[i] == candidates[i - 1]) continue;// smart!!
            if(sum + candidates[i] == target) {
                list.add(candidates[i]);
                // check equality
                //if(notEqual())
                    res.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
                break;
            }
            
            else if (sum + candidates[i] < target) {
                list.add(candidates[i]);
                helper(candidates, i + 1, sum + candidates[i], target);
                list.remove(list.size() - 1);
            }
            else
                break;
        }
        
    }
    
    boolean notEqual() {
        for(List<Integer> i: res) {
            if(i.equals(list))
                return false;
        }
        return true;
    }
}
