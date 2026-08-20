class Solution {
    public String multiply(String num1, String num2) {
        int n1=num1.length();
        int n2=num2.length();
        int[] res=new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int d1=num1.charAt(i)-'0';
                int d2=num2.charAt(j)-'0';
                int mul=d1*d2;
                int idx=i+j+1;
                int carry=i+j;
                int sum=mul+res[idx];
                res[idx]=sum%10;
                res[carry]+=sum/10;
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int n:res){
            if(!(ans.length()==0 && n==0)){
                ans.append(n);
            }
        }
        return ans.length()==0 ? "0":ans.toString();
    }
}
