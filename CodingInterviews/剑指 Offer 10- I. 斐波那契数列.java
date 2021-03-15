class Solution {
    public int fib(int n) {
        int fib1=0;
        int fib2=1;
        int fibn=fib1+fib2;
        if(n==0||n==1){
            return n;
        }
        for(int i=1;i<n;i++){
            fibn=(fib1+fib2) % 1000000007;
            fib1=fib2;
            fib2=fibn;
        }
        return fibn;
    }
}