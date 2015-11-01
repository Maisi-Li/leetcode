/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

/*
We need to avoid duplicate number in this problem
So the first step we do is to sort the array 
Then use similar function in 2 Sum 
O(n^2) time O(1) space
Long article:
http://tech-wonderland.net/blog/summary-of-ksum-problems.html
*/

/**************My solution*****************/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int tempSum = 0;
        int p1 = 0;
        int p2 = nums.length - 1;
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i - 1])
                continue;
            tempSum = -1*nums[i];
            p1 = i + 1;
            p2 = nums.length - 1;
            while(p1 < p2) {
                if(nums[p1] + nums[p2] == tempSum) {
                    result.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    while(p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                    while(p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;
                    p1++;
                    p2--;
                }
                else if(nums[p1] + nums[p2] < tempSum)
                    p1++;
                else
                    p2--;
            }
        }
        
        return result;
    }

}