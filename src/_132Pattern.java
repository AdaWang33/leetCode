import java.util.Stack;

public class _132Pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            min = Math.min(min, nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (min < nums[j] && nums[i] > nums[j]) return true;
            }
        }
        return false;
    }
}
