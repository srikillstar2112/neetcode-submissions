class Solution {
    public boolean isSubsequence(String s, String t) {
        int ss=0;
        int tt=0;
        StringBuilder res=new StringBuilder();

        while(ss!=s.length()){
            char ch=s.charAt(ss);
            while(tt<t.length()){
                if(t.charAt(tt)==ch){
                    res.append(ch);
                    tt++;
                    break;
                }else{
                    tt++;
                }
            }
            ss++;
        }
        return res.toString().equals(s);
    }
}