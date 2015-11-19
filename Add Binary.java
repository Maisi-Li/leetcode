/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

/***********my solution*************/
public class Solution {
    public String addBinary(String a, String b) {
        char[] array1 = a.toCharArray();
        char[] array2 = b.toCharArray();
        StringBuilder res = new StringBuilder();
        int i = array1.length - 1;
        int j = array2.length - 1;
        
        int sum = 0;
        int carry = 0;
        while(i > -1 || j > -1 || carry != 0) {
            int num1 = (i > -1) ? Character.getNumericValue(array1[i--]):0;
            int num2 = (j > -1) ? Character.getNumericValue(array2[j--]):0;
            sum = num1 ^ num2 ^ carry;
            carry = (num1 + num2 + carry) >= 2 ? 1:0;
            res.insert(0,sum);
        }
        
        return res.toString();
        
    }
}