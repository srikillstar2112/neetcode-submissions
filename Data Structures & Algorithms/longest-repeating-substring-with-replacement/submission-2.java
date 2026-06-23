class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int l=0;
        int maxf=0;
        int maxlen=0;
        for(int r=0;r<s.length();r++){
            freq[s.charAt(r)-'A']++;
            maxf=Math.max(maxf,freq[s.charAt(r)-'A']);
            if(((r-l+1)-maxf)>k){
                freq[s.charAt(l)-'A']--;maxf=0;
                l++;
            }
            if(((r-l+1)-maxf)<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
        }
        return maxlen;
    }
}
