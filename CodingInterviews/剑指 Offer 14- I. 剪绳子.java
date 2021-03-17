class Solution {
    public int cuttingRope(int n) {
        if(n<4){
            return n-1;
        }
        int[] dp=new int[n+1];
        dp[2]=2;
        dp[3]=3;
        int max=0;
        for(int i=4;i<=n;i++){
            max=0;
            for(int j=2;j<=i/2;j++){
                if(max<dp[j]*dp[i-j]){
                    max=dp[j]*dp[i-j];
                }
                dp[i]=max;
            }
        }
        return dp[n];
    }
}

//dp solution2
class Solution {
    public int cuttingRope(int n) {
            vector<int> dp(n + 1, 1);
            for (int i = 3; i <= n; ++i) {
                for (int j = 2; j < i; ++j) {
                    dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
                }
            }
            return dp[n];
        }
};
