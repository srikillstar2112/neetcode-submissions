class Solution {
    List<String> ans=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    private void backtrack(int open,int close,List<String> ans,int n){
        if(open==close && close==n && open==n){
            ans.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append("(");
            backtrack(open+1,close,ans,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            backtrack(open,close+1,ans,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,ans,n);
        return ans;
    }
}
