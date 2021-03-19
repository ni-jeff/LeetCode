class Solution {
    int index=0;
    int len;
    public boolean scanUnsignedInteger(String s){
        int start=index;
        while(index<len&&s.charAt(index)>='0'&&s.charAt(index)<='9'){
            index++;
        }
        return index>start;
    }
    public boolean scanSignedInteger(String s){
        if(index<len&&(s.charAt(index)=='+'||s.charAt(index)=='-')){
            index++;
        }
        return scanUnsignedInteger(s);
    }
    public boolean isNumber(String s) {
        s=s.trim();
        this.len=s.length();
        if(s==null||len==0){
            return false;
        }
        boolean res=scanSignedInteger(s);
        if(index<len&&s.charAt(index)=='.'){
            index++;
            res=scanUnsignedInteger(s)||res;
        }
        if(index<len&&(s.charAt(index)=='e'||s.charAt(index)=='E')){
            index++;
            res=scanSignedInteger(s)&&res;
        }
        return res&&(index==len);
    }
}