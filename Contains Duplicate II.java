/*
Given an array of integers and an integer k, 

find out whether there are two distinct indices i and j in the array such that 

nums[i] = nums[j] and the difference between i and j is at most k.
*/


/*
HashMap problem: simple 

some people use HashSet
https://leetcode.com/discuss/38445/simple-java-solution
*/


/************My solution*************/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k < 1 || nums.length == 1)
            return false;
        //<int, index in nums>
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i])  <= k)
                    return true;
            else
                map.put(nums[i],i); // update position
        }
        
        return false;
        
    }
}

/****************Better solution*****************/
public class Solution {
public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for(int i = 0; i <  nums.length; i++) {
        Integer ord = map.put(nums[i], i);
        if(ord != null && i - ord <= k) {
            return true;
        }
    }

    return false;
}
 
 //Don't forget that map.put also return value INTEGER
 //the previous value associated with key, or null if there was no mapping for key. 
 //(A null return can also indicate that the map previously associated null with key.)
