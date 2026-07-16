class KthLargest {
    private PriorityQueue<Integer> min;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.min=new PriorityQueue<>(k);
        for(int i:nums){
            add(i);
        }
    }
    
    public int add(int val) {
        if(min.size()<k){
            min.offer(val);
        }else if(min.peek()<val){
            min.poll();
            min.offer(val);
        }
        return min.peek();
    }
}
