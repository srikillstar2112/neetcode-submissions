class Solution {
    public int countSubstrings(String s) {
        if(s.length()<=1){
            return 1;
        }
        int np=0;
        for(int i=0;i<s.length();i++){
            int low=i;
            int high=i;
            while(s.charAt(low)==s.charAt(high)){
                np++;
                low--;
                high++;
                if(low==-1 || high==s.length()) break;
            }
            low=i;
            high=i+1;
            while((high<s.length()) && (s.charAt(low)==s.charAt(high))){
                np++;
                low--;
                high++;
                if(low==-1 || high==s.length()) break;
            }
        }
        return np;
    }
}
