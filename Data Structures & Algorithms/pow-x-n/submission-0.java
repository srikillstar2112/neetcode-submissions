class Solution {
    double ans=1;
    public double myPow(double x, int n) {
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;
        }
        if(N==0){
            return ans;
        }
        if(N%2==1){
            ans=ans*x;
            myPow(x,(int)(N-1));
        }else{
            myPow(x*x,(int)(N/2));
        }
        return ans;
    }
}
