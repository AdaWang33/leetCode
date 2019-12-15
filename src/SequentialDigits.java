import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            generateSeq(new String(), i, low, high, res);
        }
        Collections.sort(res);
        return res;
    }

    public void generateSeq(String str, int index, int low, int high, List<Integer> res) {
        if (index == 10) return;

        str += index;
        if (low <= Integer.parseInt(str) && Integer.parseInt(str) <= high) {
            res.add(Integer.parseInt(str));
        }
        index += 1;
        generateSeq(str, index, low, high, res);
    }
}
