/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

/*
Boundry conditions: overflow number 

*/


/**************Best solution*****************/
public int reverse(int x)
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}

/******Why this code is good******/
/*
1.do not need Integer.MAX_VALUE to handle overflow number by using 
newResult will be the same as result after anti operation when it's not overflow

2.do not need to deal with minus number 
a%b  = remainder of a/b * (sign of a)

*/
/***************My solution****************/
public int reverse(int x) {
        if(x ==0)
            return 0;
        // if minus
        //     ninus flag == true;
        // temp = x%10;
        // x = x%10;
        // result*10 + temp;
        
        // return
        
        boolean minusFlag = false;
        if(x < 0)   {
            x *= -1;
            minusFlag = true;
        }
        
        int temp = 0;
        long result = 0;
        
        while(x != 0)   {
            temp = x%10;
            x /= 10;
            result = result*10 + temp;
            if(result > Integer.MAX_VALUE) return 0;
            if(result < Integer.MIN_VALUE) return 0;

        }
        
            
        return minusFlag?(int)(-1*result):(int)result;
        
    }