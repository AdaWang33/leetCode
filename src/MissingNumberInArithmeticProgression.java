public class MissingNumberInArithmeticProgression {
    public int missingNumber(int[] arr) {
        int step = (arr[arr.length-1]-arr[0])/arr.length;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]+step!=arr[i+1]) return arr[i]+step;
        }
        return arr[arr.length-1]+step;
    }
}
