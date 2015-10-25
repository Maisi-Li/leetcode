/*
Given a string S, find the longest palindromic substring in S. 

You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

/*
Pretty straight forward question.

There are two case: 
1. 1122
2. 11322 
*/

/****************My method***************/
public class Solution {
    public String longestPalindrome(String s) {
        // there are two case
        // 123321
        // 1234321
        if(s.length() <=1)
            return s;
            
        char[] data = s.toCharArray();
        int len = s.length(); // q1: data.length---no length() in char[] ----- s.length()
        int begin = 0;
        int end = 0;
        int max = -1;
        
        //case 1:
        for(int i = 0; i < len - 1; i++)    {
            if(i + 1 < len && data[i] == data[i + 1])   {
                int tempLen = 1;
                while((i - tempLen) >= 0 && (i + 1 + tempLen) < len && data[i - tempLen] == data[i + 1 + tempLen])
                    tempLen++;
                tempLen--;
                if(tempLen*2  + 2> max)   {
                    max = tempLen*2 + 2;
                    begin = i -tempLen;
                    end = i + 1 + tempLen;
                }
                
            }
        }
        
        //case2:
        for(int i = 1; i < len - 1; i++)    {
            if(i + 1 < len && data[i - 1] == data[i + 1])  {
                int tempLen = 2;
                while((i - tempLen) >= 0 && (i + tempLen) < len && data[i - tempLen] == data[i + tempLen])   
                    tempLen++;
                tempLen--;
                if((tempLen*2 + 1) > max) {
                    max = tempLen*2 + 1;
                    begin = i - tempLen;
                    end = i + tempLen;
                }
                
            }
        }
        
        return s.substring(begin, end + 1);
    }
}


/****************A better Implement method***************/

public class Solution {
private int lo, maxLen;

public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2)
        return s;

    for (int i = 0; i < len-1; i++) {
        extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
        extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
    while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
        j--;
        k++;
    }
    if (maxLen < k - j - 1) {
        lo = j + 1;
        maxLen = k - j - 1;
    }
}}