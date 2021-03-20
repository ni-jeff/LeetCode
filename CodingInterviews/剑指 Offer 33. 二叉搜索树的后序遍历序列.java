// solution1: recursion
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verifySubTree(postorder,0,postorder.length);
    }
    public boolean verifySubTree(int[] postorder, int start, int end){
        if(start>=end-1)return true;
        int leftEnd=start;
        while(postorder[leftEnd]<postorder[end-1]){
            leftEnd++;
        }
        int rightEnd=leftEnd;
        while(postorder[rightEnd]>postorder[end-1]){
            rightEnd++;
        }
        return (rightEnd==end-1)&&verifySubTree(postorder,start,leftEnd)&&verifySubTree(postorder,leftEnd,rightEnd);
    }
}

// solution2 using a stack
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        // 单调栈使用，单调递增的单调栈
        Deque<Integer> stack = new LinkedList<>();
        // 表示上一个根节点的元素，这里可以把postorder的最后一个元素root看成无穷大节点的左孩子
        int root = Integer.MAX_VALUE;
        // 逆向遍历，就是翻转的先序遍历
        for (int i = postorder.length - 1;i>=0;i--){
            // 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
            if (postorder[i] > root){
                return false;
            }
            while (!stack.isEmpty() && postorder[i] < stack.peek()){
                // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
                // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
                root = stack.pop();
            }
            // 这个新元素入栈
            stack.push(postorder[i]);
        }
        return true;
    }
}