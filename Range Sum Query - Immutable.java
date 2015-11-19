/*Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

*/

//many calls mean that we should not count the number every time


/***********my solution**********/
public class NumArray {
    private int[][] array;
    public NumArray(int[] nums) {
        
        array = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum+= nums[j];
                array[i][j] = sum;
            }
        }
        
    }

    public int sumRange(int i, int j) {
        if(i > j)
            return array[j][i];
        else
            return array[i][j];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

/***********best solution***********/
public class NumArray {
    private int[]array;
    public NumArray(int[] nums) {
        
        array = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
                sum+= nums[i];
                array[i] = sum;
        }
        
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return array[j];
        else
            return array[j] - array[i - 1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);