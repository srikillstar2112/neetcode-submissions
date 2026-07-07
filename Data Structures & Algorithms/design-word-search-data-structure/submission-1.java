class Node{
    Node[] child=new Node[26];
    boolean flag=false;
    public Node(){}

    boolean contains(char c){
        return (child[c-'a']!=null);
    } 

    void addw(char c, Node node){
        child[c-'a']=node;
    }

    Node goNext(char c){
        return child[c-'a'];
    }

    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}
class WordDictionary {
    private static Node  root;
    public WordDictionary() {
        root=new Node();
    }

    public void addWord(String word) {
        //inserting
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.contains(word.charAt(i))){
                node.addw(word.charAt(i),new Node());
            }
            node=node.goNext(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return dfs(word,0, root);
    }
    private boolean dfs(String word,int idx,Node node){
        if(node==null){
            return false;
        }
        if(idx==word.length()){
            return node.flag;
        }
        if(word.charAt(idx)=='.'){
            for(Node c:node.child){
                if(c!=null && dfs(word,idx+1,c)){
                    return true;
                }
            }
            return false;
        }
        if(!node.contains(word.charAt(idx))){
            return false;
        }
        return dfs(word,idx+1,node.goNext(word.charAt(idx)));
    }
}
