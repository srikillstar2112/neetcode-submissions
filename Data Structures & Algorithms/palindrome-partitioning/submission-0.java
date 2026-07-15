class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> sub=new ArrayList<>();
        checker(0,s,res,sub);
        return res;
    }
    private void checker(int idx,String s,List<List<String>> res, List<String> sub){
        if(idx==s.length()){
            res.add(new ArrayList<>(sub));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                sub.add(s.substring(idx,i+1));
                checker(i+1,s,res,sub);
                sub.remove(sub.size()-1);
            }
        }
    }
    boolean isPalindrome(String s,int idx, int end){
        while(idx<=end){
            if(s.charAt(idx++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
