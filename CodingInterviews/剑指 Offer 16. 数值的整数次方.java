class Solution {
    public double myPow(double x, int n) {
        if(x==0){
            return 1;
        }
        long b=n;
        if(b<0){
            x=1/x;
            b=-b;
        }
        double res=1;
        while(b>0){
            if((b&1)==1){
                res*=x;
            }
            b>>=1;
            x*=x;
        }
        return res;
    }
}