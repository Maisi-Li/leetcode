/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/


/**********my solution********/
public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        char[] c = str.toCharArray();
        if(c.length == 0)
            return 0;
        int minus = 1;
        int i = 0;
        int result = 0; 
        int resultTemp = 0;
        
        if(c[0] == '-') {
            minus = -1;
            i = 1;
        }
        if(c[0] == '+') {
            i = 1;
        }
        
        while(i < c.length && c[i] >= '0' && c[i] <= '9') {
            resultTemp = result*10 + c[i] - '0';
            if((resultTemp - c[i] + '0')/10 != result) {
                if(minus == -1)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            result = resultTemp;
            i++;
        }
        
        if(minus == 1 && result < 0)
            return Integer.MAX_VALUE;
        else if (minus == -1 && result > 0)
            return Integer.MIN_VALUE;
        else
            return minus*result;

        
        
        
        //***********************//
        // 1/trim the string
        // 2.minus or not
        // 3from the begin to char or number
        //     if number 
        //         do someting
        //     else 
        //         break
        //     if > intmax or < intmin
        //         return intmax or intmin
        
        // return number
        
        // str = str.trim();
        // if(str.length() == 0)
        //     return 0;
        // int len = str.length();
        // boolean minus = false;
        // int i = 0;
        // char temp = '0';
        // long result = 0;
        // if(str.charAt(0) == '-')    {
        //     minus = true;
        //     i = 1;
        // }
        // if(str.charAt(0) == '+')
        //     i = 1;
        // for(;i < len;i++)   {
        //     temp = str.charAt(i);
        //     if(temp - '0' >=0 && temp - '0' < 10)   {
        //         result = result*10 + (temp  - '0');
        //     }
        //     else
        //         break;
        //     if(result > Integer.MAX_VALUE)
        //         return Integer.MAX_VALUE;
        //     if(result < Integer.MIN_VALUE)
        //         return Integer.MIN_VALUE;
        // }    
        
        // return minus?(int)(-1*result):(int)result;
        
    }
}