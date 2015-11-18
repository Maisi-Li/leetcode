/*1
11
21
1211
111221
312211
13112221
1113213211
31131211131221
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

*/

/***********my solution***********/
public class Solution {
    public String countAndSay(int n) {
        int count = 0;
        String res = "1";
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i < n; i++) {
            char num = res.charAt(0);
            count = 1;
            builder = new StringBuilder();
            for(int j = 1; j < res.length(); j++) {
                if(res.charAt(j) != num) {
                    builder.append(count).append(num);
                    num = res.charAt(j);
                    count = 1;
                }
                else
                    count++;
            }
            builder.append(count).append(num);
            res = builder.toString();
        }
        
        return res;
    }
}