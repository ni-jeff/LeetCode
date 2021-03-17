class Solution {
    public int[] printNumbers(int n) {
        int max=(int)Math.pow(10,n)-1;
        int[] res=new int[max];
        for(int i=0;i<max;i++){
            res[i]=i+1;
        }
        return res;
    }
}

// solution2: bigdecimal problem
class Solution {
    int[] res;
    char[] digit={'0','1','2','3','4','5','6','7','8','9'};
    char[] num;
    int count=0;
    int zeroNum;
    int nine=0;
    int n;
    public int[] printNumbers(int n) {
        this.n=n;
        res=new int[(int)Math.pow(10,n)-1];
        num=new char[n];
        zeroNum=n-1;
        dfs(0);
        return res;
    }
    public void dfs(int numAt){
        if(numAt==n){
            String s=String.valueOf(num).substring(zeroNum);
            if(!s.equals("0")){
                res[count++] = Integer.parseInt(s);
            }
            if(n - zeroNum == nine) zeroNum--;
            return;
        }
        for(char i:digit){
            if(i=='9'){
                nine++;
            }
            num[numAt]=i;
            dfs(numAt+1);
        }
        nine--;
    }
}