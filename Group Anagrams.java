/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/


/***********my solution***********/
//what I am thinking is to check every combination of a certain 
//word and see if some word might match
public class Solution {
    List<List<String>> res;
    List<String> list;
    HashMap<String, Integer> map;
    public List<List<String>> groupAnagrams(String[] strs) {
        res = new ArrayList<>();
        map = new HashMap<>();
        
        for(String i : strs) 
            map.put(i,1);
        
        for(String i: strs) {
            if(map.get(i) != null) {
                list = new ArrayList<>();
                getAnagrams(list,i, 0);
                res.add(new ArrayList(list));
            }
        }
        
        return res;
        
    }
    
    private void getAnagrams(List<String> list, String word, int pos) {
        
        if(map.get(word) != null) {
            list.add(word);
            map.remove(word);
        }
        if(pos == word.length() - 1)
            return;
            
        char [] array = word.toCharArray();
        for(int i = pos; i < word.length(); i++) {
            swap(array, pos, i);
            getAnagrams(list, new String(array), pos + 1);
            swap(array, pos, i);
        }
    }
    
    private void swap(char[] word, int x, int y) {
        char temp = word[x];
        word[x] = word[y];
        word[y] = temp;
    }
}


/*************8better one***************/
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Arrays.sort(strs);
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String i : strs) {
            char[] temp = i.toCharArray();
            Arrays.sort(temp);
            String key = Arrays.toString(temp);
            if(!map.containsKey(key))
                map.put(key,new ArrayList<String>());
            map.get(key).add(i);
                
        }
        
        return new ArrayList<List<String>>(map.values());
        
    }
}	