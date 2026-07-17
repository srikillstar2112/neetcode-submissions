class Solution {
    public int findKthLargest(int[] nums, int k) {
        int t=nums.length-k;
        int left=0;
        int right=nums.length-1;
        while(true){
            int pivot=partition(nums,left,right);
            if(pivot==t){
                return nums[pivot];
            }else if(pivot>t){
                right-=1;
            }else{
                left+=1;
            }
        }
    }
        public int partition(int[] nums,int left,int right){
            int pivot=nums[right];
            int i=left;
            for(int j=left;j<right;j++){
                if(nums[j]<pivot){
                    swap(nums,i,j);
                    i++;
                }
            }
            swap(nums,i,right);
            return i;
        }
        private void swap(int[] nums, int i, int j){
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
        }
    }

