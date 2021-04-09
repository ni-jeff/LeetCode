// solution1: min heap+max heap
class MedianFinder {
    Queue<Integer> former;
    Queue<Integer> latter;
    /** initialize your data structure here. */
    public MedianFinder() {
        former=new PriorityQueue<>((i1,i2)->(i2-i1));
        latter=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(former.size()==latter.size()){
            latter.offer(num);
            former.offer(latter.poll());
        }
        else{
            former.offer(num);
            latter.offer(former.poll());
        }
    }
    
    public double findMedian() {
        if(former.size()==latter.size()){
            return ((double)(former.peek())+(double)(latter.peek()))/2;
        }
        else return (double)(former.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */