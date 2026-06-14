class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int max=0; int n=heights.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                int ele=st.pop();
                int nse=i;
                int pse=st.isEmpty() ? -1 : st.peek();
                max=Math.max(max,(nse-pse-1)*heights[ele]);
            }
            st.push(i);   
        }
        while(!st.isEmpty()){
            int nse=n;
            int ele=st.pop();
            int pse=st.isEmpty() ? -1: st.peek();
            max=Math.max(max,(nse-pse-1)*heights[ele]);
        }
        return max;
    }
}
