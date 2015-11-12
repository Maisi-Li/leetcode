/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/

/*
hashmap.put<key,value> will return previous value under the key. if the key not exist, then will return null
string.split(" "): return String[]
the problem request key to value is one to one. so we put all key and value into the hashmap, the value we insert is i
and the hashmap can declare as HashMap !!! do not need to specify the type!!!!
*/

/**************my solution*************/
 public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null)
            return false;
        String[] words = str.split("\\s");    
        
        if(words.length != pattern.length())
            return false;
            
        HashMap<Character, String> map = new HashMap<>();
        char key = 0;
        for(int i = 0; i < pattern.length(); i++)   {
            key = pattern.charAt(i);
            if(map.get(key) == null)    {
                if(map.containsValue(words[i]))
                    return false;
                map.put(key, words[i]);
                continue;
            }
            
            if(!words[i].equals(map.get(key)))
                return false;
        }
        
        return true;
        
    }
	
/****************best solution**************/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");
        if (word.length != pattern.length())
        return false;
        HashMap map = new HashMap<>();    
        for(int i = 0; i < word.length; i++) {
            if(!Objects.equals(map.put(word[i], i), map.put(pattern.charAt(i), i)))
                return false;
        }
        
        return true;
    }
}