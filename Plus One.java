/*Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Subscribe to see which companies asked this question

*/

/*
straightforward problem, but have better method 

do not need carry and move the whole array to a new one
*/

/****************My method******************/
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0)
            return digits;
            int carry = 0;
        for(int i = digits.length - 1; i >=0; i--)  {
            if(digits[i] == 9)  {
                carry = 1;
                digits[i] = 0;
                continue;
            }
            else if (carry == 1)    {
                carry = 0;
            }
            digits[i] ++;
            break;
        }
        
        if(carry == 0)
            return digits;
        else    {
            int[] temp = new int[digits.length + 1];
            temp[0] = 1;
            for(int i = 1; i < temp.length; i++)    {
                temp[i] = digits[i - 1];
            }
            return temp;
        }    
        
    }
}


/**************Better one******************/
public int[] plusOne(int[] digits) {

    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }

        digits[i] = 0;
    }

    int[] newNumber = new int [n+1];
    newNumber[0] = 1;

    return newNumber;
}

