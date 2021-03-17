class Solution {
    public int cuttingRope(int n) {
        if(n<4){
            return n-1;
        }
        int powNum=n/3;
        int rest=n%3;
        long res=1l;
        for(int i=0;i<powNum-1;i++){
            res=res*3%1000000007;
        }
        if(rest==0){
            return (int)(res*3%1000000007);
        }
        else if(rest==1){
            return (int)(res*4%1000000007);
        }
        else if(rest==2){
            return (int)(res*6%1000000007);
        }
        return -1;
    }
}
// notes: 先进行强制数据类型转换再计算取余，进行类型转换建议全部加括号