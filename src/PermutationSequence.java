import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    List<String> list = new ArrayList<>();

    public String getPermutation(int n, int k) {
        String remains = new String();
        for (int i = 1; i <= n; i++) remains += i;

        int beginWith = k / factorial(n - 1);
        int countAt = k % factorial(n - 1);
        if (countAt == 0) {
            helper(new String() + remains.charAt(beginWith - 1), remains.substring(0, beginWith - 1) + remains.substring(beginWith), n);
            return list.get(list.size() - 1);
        } else {
            helper(new String() + remains.charAt(beginWith), remains.substring(0, beginWith) + remains.substring(beginWith + 1), n);
            return list.get(countAt - 1);
        }
    }

    public int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public void helper(String str, String remains, int n) {
        if (str.length() == n) {
            list.add(str);
            return;
        }
        for (int i = 0; i < remains.length(); i++) {
            char c = remains.charAt(i);
            String res = remains.substring(0, i) + remains.substring(i + 1);
            helper(str + c, res, n);
        }

    }
}
