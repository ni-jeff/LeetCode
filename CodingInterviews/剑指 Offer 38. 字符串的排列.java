class Solution {
    public String[] permutation(String s) {
        char[] c=s.toCharArray();
        List<String> list= new LinkedList<>();
        backtrack(0,c,list);
        return list.toArray(new String[list.size()]);
    }
    public void backtrack(int index,char[] s,List<String> list){
        if(index==s.length-1){
            list.add(String.valueOf(s));
            return;
        }
        HashSet<Character> set=new HashSet<>();
        for(int i=index;i<s.length;i++){
            if(set.contains(s[i])){
                continue;
            }
            set.add(s[i]);
            swap(i,index,s);
            backtrack(index+1,s,list);
            swap(i,index,s);
        }
    }
    public void swap(int i,int j,char[] s){
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }
}