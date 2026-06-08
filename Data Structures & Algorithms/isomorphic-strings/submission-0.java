class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> map1=new HashMap<>();
       HashMap<Character,Integer> map2=new HashMap<>();
        for( char c: s.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray()){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        List<Integer> l1=new ArrayList<>(map1.values());
        List<Integer> l2=new ArrayList<>(map2.values());
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }
}