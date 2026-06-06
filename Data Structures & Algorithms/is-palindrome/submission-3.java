class Solution {
    public boolean isPalindrome(String s) {
        String rep=s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        int left=0;
        int right=rep.length()-1;
        int count=0;
        while(left<right){
            if(rep.charAt(left)!=rep.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
    return true;
        
        }
}
