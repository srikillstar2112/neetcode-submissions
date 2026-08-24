class Solution {
    private boolean buildGraph(Map<Character,List<Character>> graph,
            Map<Character,Integer> ind,String[] words){
        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            int len=Math.min(s1.length(),s2.length());
            if(s1.length()>s2.length() && s1.substring(0,len).equals(s2)){
                return false;
            }
            for(int j=0;j<len;j++){
                char c1=s1.charAt(j);
                char c2=s2.charAt(j);
                if(c1!=c2){
                    if(!graph.get(c1).contains(c2)){
                        graph.get(c1).add(c2);
                        ind.put(c2,ind.get(c2)+1);
                    }
                    break;
                }
            }
        }
        return true;
    }
    public String foreignDictionary(String[] words) {
      Map<Character,List<Character>> graph=new HashMap<>();
      Map<Character,Integer> ind=new HashMap<>();
      for(String word: words){
        for(char c:word.toCharArray()){
            graph.putIfAbsent(c,new ArrayList<>());
            ind.putIfAbsent(c,0);
        }
      }
      if(!buildGraph(graph,ind,words)){
        return "";
      }
      Queue<Character> topo=new LinkedList<>();
      for(char c: ind.keySet()){
        if(ind.get(c)==0){
            topo.offer(c);
        }
      }
      StringBuilder ans=new StringBuilder();
      while(!topo.isEmpty()){
        char curr=topo.poll();
        ans.append(curr);
        for(char next:graph.get(curr)){
            ind.put(next,ind.get(next)-1);
            if(ind.get(next)==0){
                topo.offer(next);
            }
        }
      }
      if(ans.length()!=ind.size()){ return "";}
      return ans.toString();
    }
}
