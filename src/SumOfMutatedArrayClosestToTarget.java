import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int leftSum = 0;
        int avgRight = 0;

        for(int i=0;i<len;i++){
            int ele = arr[i];
            avgRight = Math.abs((target-leftSum)/(len-i)*(len-i)-(target-leftSum))>Math.abs(((target-leftSum)/(len-i)+1)*(len-i)-(target-leftSum))?((target-leftSum)/(len-i)+1):(target-leftSum)/(len-i);
            if(leftSum+ele*(len-i)>target) return avgRight;
            leftSum+=ele;
        }
        return arr[arr.length-1];
    }
}
