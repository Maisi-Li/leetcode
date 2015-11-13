/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/


/*************old solution*************/
import java.util.*;
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2)
        return false;
        
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)    {
            if(table.get(nums[i]) == null)
                table.put(nums[i],i);
            else
            return true;
        }
        return false;
    }
}

/************my new solution**************/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums) {
            if(map.put(i,1) != null)
                return true;
        }
        
        return false;
    }
}