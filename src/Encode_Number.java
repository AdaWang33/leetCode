import java.util.Collections;

public class Encode_Number {
    public String encode(int num) {
        if (num == 0) return new String();

        int[] returns = decideRange(num);
        int basic = returns[0];
        int difference = returns[1];

//        String binaryString = String.join("", Collections.nCopies(basic, "0"));
//        if (difference == 0) return binaryString;

        StringBuilder binaryDifference = new StringBuilder("");
        for (int i = 0; i < basic; i++) {
            binaryDifference.append(Integer.toString(1 & difference));
            difference = difference >> 1;
        }

        binaryDifference = binaryDifference.reverse();
        return binaryDifference.toString();

    }

    public int[] decideRange(int num) {
        int n = 1;
        int sum = 2;
        while (num > sum) {
            n++;
            sum += Math.pow(2, n);
        }
        int differnce = num - (int) sum + (int) Math.pow(2, n) - 1;
        return new int[]{n, differnce};
    }
}
