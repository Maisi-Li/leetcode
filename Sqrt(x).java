/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

/**********newton ***********/
public class Solution {
    int mySqrt(int x) {
        long r = x;
        while (r*r > x)
        r = (r + x/r) / 2;
        return (int) r;
    }
}

/*********my solution**************/
// binary search
int sqrt(int x) {
    long long i = 0;
    long long j = x / 2 + 1;
    while (i <= j)
    {
        long long mid = (i + j) / 2;
        long long sq = mid * mid;
        if (sq == x) return mid;
        else if (sq < x) i = mid + 1;
        else j = mid - 1;
    }
    return j;
}

/***********bit shift************/
public class Solution {
    public int mySqrt(int x) {
    if(x==0)
        return 0;
    int h=0;
    while((long)(1<<h)*(long)(1<<h)<=x) // firstly, find the most significant bit
        h++;
    h--;
    int b=h-1;
    int res=(1<<h);
    while(b>=0){  // find the remaining bits
        if((long)(res | (1<<b))*(long)(res |(1<<b))<=x)
            res|=(1<<b);
        b--;
    }
    return res;
}
}