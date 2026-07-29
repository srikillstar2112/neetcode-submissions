class Pair{
    String first;
    int sec;
    Pair(String first,int second){
        this.first=first;
        this.sec=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        Set<String> set=new HashSet<>();
        
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            String word=q.peek().first;
            int step=q.peek().sec;
            q.poll();
            if(word.equals(endWord)==true) return step;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replaced=word.toCharArray();
                    replaced[i]=ch;
                    String guess=new String(replaced);
                    if(set.contains(guess)==true){
                        set.remove(guess);
                        q.add(new Pair(guess,step+1));
                    }
                }
            }
        }
        return 0;
    }
}
