public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--; // find the one that breaks desc order
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--; // find the smallest one that is larger then breaker
            swap(nums, i, j);
        }
        reverOrder(nums, i + 1, nums.length - 1);

    }

    public void swap(int[] nums, int p, int q) {
        int tmp;
        tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    public void reverOrder(int[] nums, int p, int q) {
        while (p <= q) swap(nums, p++, q--);
    }
}
