/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
*/

/*************my solution*************/
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
        // if(s.length() != t.length())
        //     return false;
        // if(s.length() == 0)
        //     return true;
        
        // HashMap<Character, Integer> map = new HashMap<>();
        // char temp = ' ';
        // for(int i = 0; i < s.length(); i++) {
        //     temp = s.charAt(i);
        //     map.put(temp, map.containsKey(temp)?map.get(temp) + 1: 1);
        // }
        
        // for(int i = 0; i < t.length(); i++) {
        //     temp = t.charAt(i);
        //     if(!map.containsKey(temp))
        //         return false;
        //     if(map.get(temp) == 1)
        //         map.remove(temp);
        //     else
        //         map.put(temp, map.get(temp) - 1);
        // }
        
        // return map.isEmpty();
    }
}