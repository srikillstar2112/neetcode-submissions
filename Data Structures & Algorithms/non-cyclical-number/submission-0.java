class Solution {
    private int sumOfSquares(int n){
        int sum=0;
        while(n!=0){
            int digit=n%10;
            sum+= digit*digit;
            n /=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();  
        int sum=sumOfSquares(n);
        while(!set.contains(sum)){
            if(sum==1){
                return true;
            }
            set.add(sum);
            sum=sumOfSquares(sum);
        }
        return false;
    }
}
