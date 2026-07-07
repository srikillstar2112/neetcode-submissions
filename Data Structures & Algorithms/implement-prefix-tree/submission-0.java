class Node{
    Node[] children=new Node[26];
    boolean flag=false;
    public Node(){}

    boolean contains(char c){
        return (children[c-'a']!=null);
    }
    void put(char c,Node node){
        children[c-'a']=node;
    }
    Node goNext(char c){
        return children[c-'a'];
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}

class PrefixTree {
    private static Node root;
    public PrefixTree() {
        root=new Node();
    }

    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.contains(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node=node.goNext(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.contains(word.charAt(i))){
                return false;
            }
            node=node.goNext(word.charAt(i));
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            if(!node.contains(prefix.charAt(i))){
                return false;
            }
            node=node.goNext(prefix.charAt(i));
        }
        return true;
    }
}
