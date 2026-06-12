class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String s: tokens){
            if(s.charAt(0)=='+' ){
                int a=st.pop();
                int b=st.pop();
                st.push(b+a);
            }else if(s.charAt(0)=='*'){
                int a=st.pop();
                int b=st.pop();
                st.push(b*a);
            }else if(s.charAt(0)=='/'){
                int a=st.pop();
                int b=st.pop();
                st.push(b/a);
            }else if(s.charAt(0)=='-'){
                int a=st.pop();
                int b=st.pop();
                st.push(b-a);
            }else{
                if(!s.isEmpty()){
                    st.push(Integer.parseInt(s));
                }
            }
        }
        return st.pop();
    }
}
