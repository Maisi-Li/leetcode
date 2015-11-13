/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/
/*****************my solution************/
public class Solution {
    public boolean isHappy(int n) {
        if(n <= 1)
            return true;
            
        int sum = 0;
        int tempNum = n;
        int temp = 0;
        List<Integer> list = new ArrayList<Integer>();
        while(sum != n)    {
            if(sum == 1)
                return true;
            sum = 0;
            while(tempNum != 0) {
                temp = tempNum%10;
                sum += temp*temp;
                tempNum /= 10;
            }
            tempNum = sum;
            if(list.contains(tempNum))
                return false;
            list.add(tempNum);

        }
        
        return false;
    }
}
/***************better solution**********/
//Floyd Cycle detection algorithm
int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    bool isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            if(fast == 1) return 1;
        } while(slow != fast);
         return 0;
}