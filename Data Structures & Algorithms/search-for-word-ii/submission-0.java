class Node{
    Node[] links=new Node[26];
    String word;
    public Node(){};
}
//dfs method
//buildtree method
class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Node node=buildTree(words);
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,i,j,node);
            }
        }
        return ans;
    }
    private void dfs(char[][] board,int i, int j,Node node){
        //Case : Out of bounds
        if(i<0 || j<0 || i==board.length || j==board[0].length){
            return;
        }
        char c=board[i][j];
        //Case : Already visited
        if(c=='%'){
            return;
        }
        if(node.links[c-'a']==null){
            return;
        }
        node=node.links[c-'a'];
        if(node.word!=null){
            // Word present
            ans.add(node.word);
            node.word=null;
        }
        board[i][j]='%';
        dfs(board,i+1,j,node);
        dfs(board,i,j+1,node);
        dfs(board,i-1,j,node);
        dfs(board,i,j-1,node);
        board[i][j]=c;
    }
    private Node buildTree(String[] words){
        Node root=new Node();
        for(String word:words){
            Node n=root;
            for(char c:word.toCharArray()){
                if(n.links[c-'a']==null){
                    n.links[c-'a']=new Node();
                }
                n=n.links[c-'a'];
            }
            n.word=word;
        }
        return root;
    }
}
