import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hexspeak {
    public String toHexspeak(String num) {
        if (num == null || num.length() == 0) return new String();
        long numLong = Long.parseLong(num);
        List<Integer> hexlist = new ArrayList<>();

        // 油渣，再肉
        while (numLong != 0) {
            int bit = (int) (numLong % 16);
            hexlist.add(bit);
            numLong /= 16;
        }

        StringBuilder res = new StringBuilder();
        String hex = "OI23456789ABCDEF";
        for (int bit : hexlist) {
            if (bit == 0 || bit == 1 || (10 <= bit && bit <= 15)) {
                res.append(hex.charAt(bit));
            } else {
                return "ERROR";
            }
        }

        res = res.reverse();
        return res.toString();

    }
}
