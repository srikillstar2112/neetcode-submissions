class Solution {
    private boolean isSafe(int row,int n, int col, List<String> sub){
        for(int i=0;i<row;i++){
            if(sub.get(i).charAt(col)=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(sub.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(sub.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        return true;
    }
    void nQueens(int n,int row,List<List<String>> ans,List<String> sub){
        if(row==n){
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(row,n,i,sub)){
                char[] arr=new char[n];
                Arrays.fill(arr,'.');
                arr[i]='Q';
                sub.add(new String(arr));
                nQueens(n,row+1,ans,sub);
                sub.remove(sub.size()-1);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        nQueens(n,0,ans,new ArrayList<>());
        return ans;
    }
}
