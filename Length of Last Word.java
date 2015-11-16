/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

/*********my solution**********/
public class Solution {
    public int lengthOfLastWord(String s) {
        int sum = 0;
        int i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == ' ') i--;
        
        for(; i >= 0; i--) {
            if(s.charAt(i) == ' ')
                break;
            sum++;
        }
        return sum;
        
    }
}