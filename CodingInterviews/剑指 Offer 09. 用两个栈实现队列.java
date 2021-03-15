class CQueue {
    public Deque<Integer> stack1;
    public Deque<Integer> stack2;
    public CQueue() {
        stack1= new LinkedList<Integer>();
        stack2= new LinkedList<Integer>();
    }
   
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if(!stack2.empty()){
            return stack2.pop();
        }
        else if(!stack1.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        return -1;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */


//  Notes: stack类已经废除，应使用deque类实现stack。