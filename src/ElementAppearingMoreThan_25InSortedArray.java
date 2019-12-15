import java.util.HashMap;

public class ElementAppearingMoreThan_25InSortedArray {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int bigKey = arr[0];
        int bigVal = 0;

        for (int ele : arr) {
            int newVal = map.getOrDefault(ele, 0) + 1;
            map.put(ele, newVal);
            if(newVal>bigVal) {
                bigKey = ele;
                bigVal = newVal;
            }
        }
        return bigKey;
    }
}
