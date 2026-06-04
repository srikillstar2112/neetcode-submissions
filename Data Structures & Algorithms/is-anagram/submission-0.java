class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        HashMap<Character,Integer> str=new HashMap<>();
        HashMap<Character,Integer> ttr=new HashMap<>();
         
         for(int i=0;i<s.length();i++){
            str.put(s.charAt(i),str.getOrDefault(s.charAt(i),0)+1);
            ttr.put(t.charAt(i),ttr.getOrDefault(t.charAt(i),0)+1);
         }
         return str.equals(ttr);
    }
}
