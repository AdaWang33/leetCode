public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        int missNum = (nums[nums.length-1]-nums[0])-(nums.length-1);
        if(missNum<k) return nums[nums.length-1]+(k-missNum);

        int left = 0;
        int right = nums.length-1;

        while(left<right-1){
            int mid = left+(right-left)/2;
            int missLeft = nums[mid]-nums[left]-(mid-left);
            if(missLeft<k){
                k-=missLeft;
                left = mid;
            }else{
                right = mid;
            }
        }

        return nums[left]+(k);
    }
}
