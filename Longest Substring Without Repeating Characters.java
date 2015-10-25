/*
Given a string, find the length of the longest substring without repeating characters. 

For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 

For "bbbbb" the longest substring is "b", with the length of 1.
*/

/*
http://www.shuatiblog.com/blog/2014/04/27/longest-substring-without-repeating/

non-repeaded characters -> hashmap 
However, characters are limit, so we have a better choice int[128] table

longest substring -> 2 pointer: pLeft and pRight 

The idea is that check if every character has already appeared before: 
if not -> update the character position in table
otherwise -> update pLeft equal to the last position of this charachter

for every loop, update max length
*/


/**********review 1 method ************/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
		if(s.length() == 0) return 0;
        
        int[] table = new int[128];
        for(int i = 0; i < 128; i++)
            table[i] = -1;
        
        int pLeft = 0;
        char tempC = '\0';
        int max = 0;
        for(int pRight = 0; pRight < s.length(); pRight++) {
            tempC = s.charAt(pRight);
            if(table[tempC] >= 0 && pLeft <= table[tempC]) {
                pLeft = table[tempC] + 1;
            }
            table[tempC] = pRight;
            if(max < pRight - pLeft + 1)
                max = pRight - pLeft + 1;
        }
        
        return max;
	}
}

/*****************method before******************/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
	}
}