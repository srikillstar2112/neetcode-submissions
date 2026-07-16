class Solution {
    public int lastStoneWeight(int[] nums) {
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums){
            max.offer(i);
        }
        while(max.size()>1){
            int a=max.poll();
            int b=max.poll();
            if(a!=b){
                max.offer(a-b);
            }
        }
        return max.isEmpty() ? 0: max.peek();
    }
}
