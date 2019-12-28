public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int maxRight = arr[arr.length-1];
        int curMax = Integer.MIN_VALUE;
        for(int i =arr.length-2;i>=0;i--){
            curMax = Math.max(arr[i],maxRight);
            arr[i] = maxRight;
            if(curMax>maxRight){
                maxRight = curMax;
            }
        }
        arr[arr.length-1] = -1;
        return arr;
    }

}
