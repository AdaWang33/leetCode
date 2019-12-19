public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        boolean isEnd = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ' && isEnd) return res;
            else if (c != ' ') {
                res++;
                isEnd = true;
            }
        }
        return res;
    }
}
