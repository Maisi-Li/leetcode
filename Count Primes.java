/*Description:

Count the number of prime numbers less than a non-negative number, n.

*/

/*************my solution************/
// time O(N*sqrt(N)) space(1)
public int countPrimes(int n) {
        if(n <= 2)
            return 0;
         
        int res = 1;
        for(int i = 3; i < n; i+=2) {
            if(isPrime(i))
                res++;
        }
        
        return res;
    }
    
    private boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i == 0)
                return false;
        }
        
        return true;
    }
	
/*************faster solution*************/
// time O(n) space(O(n))
public class Solution {
    public int countPrimes(int n) {
        if(n <= 2)
            return 0;
        boolean [] notPrime = new boolean[n];
        int count = 1;
         // default value is false
        for(int i = 3; i < n; i+=2) {
            if(!notPrime[i]) {
                count++;
                for(int j = 2; i*j < n; j++) {
                    notPrime[i*j] =true;
                }
            }
        }
        
        return count;
        
    }
    
}
