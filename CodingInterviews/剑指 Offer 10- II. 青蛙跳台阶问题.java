class Solution {
    public int numWays(int n) {
        int fib1=1;
        int fib2=1;
        int fibn=fib1+fib2;
        if(n==0||n==1){
            return fib1;
        }
        for(int i=1;i<n;i++){
            fibn=(fib1+fib2)%1000000007;
            fib1=fib2;
            fib2=fibn;
        }
        return fibn;
    }
}
//notes：规律性问题一般都用递推。先找到规律。