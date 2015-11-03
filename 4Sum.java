/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

// similar to 3 sum 

/**************My solution********************/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();// ArrayList not List
        Arrays.sort(nums);    
        int i = 0, j = 0, k = 0, l = 0;
        int len = nums.length;

        for(i = 0; i < len - 3; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(j = i + 1; j < len - 2; j++) {
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                k = j + 1;
                l = len - 1;
                while( k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target) {
						// the other way to add a list
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while(k < l && nums[k] == nums[k + 1]) k++;
                        while(k < l && nums[l] == nums[l - 1]) l--;
                        k++;
                        l--;
                    }
                    else if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
            
        }
        return res;    
        
    }
}