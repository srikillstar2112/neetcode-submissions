class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int l=0;
        int maxf=0;
        int maxlen=0;
        int r=0;
        while(r<s.length()){
            freq[s.charAt(r)-'A']++;
            maxf=Math.max(maxf,freq[s.charAt(r)-'A']);
            while(((r-l+1)-maxf)>k){
                freq[s.charAt(l)-'A']--;maxf=0;
                for(int i=0;i<26;i++){
                    maxf=Math.max(maxf,freq[i]);
                }
                l++;
            }
            if(((r-l+1)-maxf)<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}
