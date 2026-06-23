class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }
        int[] s1c=new int[26];
        int[] win=new int[26];
        for(int i=0;i<s1.length();i++){
            s1c[s1.charAt(i)-'a']++;
            win[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(s1c,win)){
            return true;
        }
        for(int j=s1.length();j<s2.length();j++){
            win[s2.charAt(j)-'a']++;
            win[s2.charAt(j-s1.length())-'a']--;
            if(Arrays.equals(s1c,win)){
                return true;
            }
        }
        return false;
    }
}
