class Solution {
    public String minWindow(String s, String t) {
        int m=t.length();
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        int minlen=Integer.MAX_VALUE;
        int subs=-1;
        for(int i=0;i<m;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int count=0;int l=0;int r=0;
        while(r<n){
            if(map.getOrDefault(s.charAt(r), 0)>0){
                count+=1;
            }
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r), 0)-1);
            while(count==m){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    subs=l;
                }
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)+1);
                if(map.get(s.charAt(l))>0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return subs== -1? "" : s.substring(subs,subs+minlen);
    }
}
