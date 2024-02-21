public class removeDuplicatesFromSortedArray {
        public int removeDuplicates(int[] nums) {
            int i=0, j=0;
            for(;i<nums.length;i++) {
                while(i>0 && i<nums.length && nums[i-1]==nums[i]) {
                    i++;
                }
                if (i<nums.length) {
                    nums[j++] = nums[i];
                }
            }
    
            return j;
        }
}
