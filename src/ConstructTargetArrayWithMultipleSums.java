import java.util.Arrays;

public class ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {
        Arrays.sort(target);
        int n = target.length;
        long total = 0;
        for(int num:target){
            total+=num;
        }

        while(true){
            int max = target[n-1];
            total-=max;
            if(max==1||total==1) return true;
            if(total>max||max%total==0) return false;

            max%=total;
            total+=max;
            target[n-1] = max;
            Arrays.sort(target);
        }
    }
}
