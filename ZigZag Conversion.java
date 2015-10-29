/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

And then read line by line: "PAHNAPLSIIGYIR"

https://leetcode.com/problems/zigzag-conversion/
*/

/*
The idea is that for n rows. write the character down and up.

*/

/*******************Best method ********************/
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1)
            return s;
        String[] res = new String[numRows];
        for(int i = 0; i < numRows; i++) res[i] = ""; // initialize string 
        int pos = 0;
        boolean down = false;
        
        for(char c : s.toCharArray()) { // iterate array 
            res[pos] += c; // char plus string 
            if(pos == 0 || pos == numRows - 1) down = !down;
            if(down)
                pos++;
            else
                pos--;
        }
        
        String result = "";
        for(String ss: res) result += ss;
            
        return result;
	}
}

/*******************My method******************/
public class Solution {
    public String convert(String s, int numRows) {
		if(s.length() <=1 || numRows <=1)
            return s;
        int len = s.length();
        StringBuilder[] result = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++)    {
            result[i] = new StringBuilder();
        }
        int i = 0;
        while(i < len)  {
            // vertical
            for(int j = 0; j < numRows && i < len; j++, i++)   {
                result[j].append(s.charAt(i));
            }
            
            // reverse
            for(int j = numRows -2; j > 0 && i < len; j--, i++)   {
                result[j].append(s.charAt(i));
            }
            
        }
        
        for(i = 1; i < numRows; i++)    {
            result[0].append(result[i]);
        }
        
        return result[0].toString();
		
	}
}