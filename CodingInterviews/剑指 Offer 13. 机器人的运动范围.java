class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        return dfs(0,0,m,n,k,visited);
    }
    public int dfs(int i,int j,int m,int n,int k,boolean[][] visited){
        if(i>=m||j>=n||visited[i][j]==true||indexSum(i)+indexSum(j)>k){
            return 0;
        }
        visited[i][j]=true;
        return 1+dfs(i+1,j,m,n,k,visited)+dfs(i,j+1,m,n,k,visited);
    }
    public int indexSum(int n){
        int sum=0;
        while(n!=0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}