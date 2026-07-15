class Solution {
    List<String> ans=new ArrayList<>();
    String[] phone={
        "","","abc","def",
        "ghi","jkl","mno",
        "pqrs","tuv","wxyz"
    };
    private void backtrack(String digits,StringBuilder sb,int idx){
        if(idx==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters=phone[digits.charAt(idx)-'0'];
        for(int i=0;i<letters.length();i++){
            sb.append(letters.charAt(i));
            backtrack(digits,sb,idx+1);
            sb.delete(sb.length()-1,sb.length());
        }

    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return ans;
        }
        backtrack(digits,new StringBuilder(), 0);
        return ans;
    }
}
