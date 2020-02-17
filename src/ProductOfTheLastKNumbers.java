import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {
    List<Integer> nums = new ArrayList<>();
    public ProductOfTheLastKNumbers() {
        add(0);
    }

    public void add(int num) {
        if(num>0){
            nums.add(nums.get(nums.size()-1)*num);
        }else{
            nums = new ArrayList<>();
            nums.add(1);
        }
    }

    public int getProduct(int k) {
        int size = nums.size();
        if(k>=size) return 0;
        return nums.get(size-1)/nums.get(size-k-1);
    }

}
