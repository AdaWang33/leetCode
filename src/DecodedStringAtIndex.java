import java.util.Stack;

public class DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        if (K == 1) return Character.toString(S.charAt(0));
        int N = S.length();
        long length = 0;

        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) length *= (c - '0');
            else length++;
        }

        for (int i = N - 1; i >= 0; i--) {
            K %= length;
            if (K == 0 && !Character.isDigit(S.charAt(i))) return Character.toString(S.charAt(i));
            if (Character.isDigit(S.charAt(i))) {
                length /= S.charAt(i) - '0';
            } else {
                length--;
            }
        }
        throw null;
    }
}
