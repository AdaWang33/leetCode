/**
 * There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right. Initially, all the bulbs are turned off.
 * <p>
 * At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.
 * <p>
 * Return the number of moments in which all turned on bulbs are blue.
 */

public class BulbSwitcherIII {
    public int numTimesAllBlue(int[] light) {
        int res = 0;
        int rightMost = 0;
        for (int i = 0; i < light.length; i++) {
            rightMost = Math.max(rightMost, light[i]);
            if (rightMost == i + 1) res++;
        }
        return res;
    }
}
