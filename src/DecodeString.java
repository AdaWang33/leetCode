import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        if (s.length() == 0) return new String();

        Stack<Integer> times = new Stack<>();
        Stack<Character> str = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int val = 0;
                while (Character.isDigit(s.charAt(i))) {
                    val = 10 * val + s.charAt(i) - '0';
                    i++;
                }
                times.push(val);
            }

            if (s.charAt(i) == ']') {
                StringBuilder cur = new StringBuilder();
                while (!str.isEmpty() && str.peek() != '[') {
                    cur.insert(0, str.pop());
                }
                str.pop();  // 把'['pop掉
                String curString = cur.toString();
                StringBuilder repeatString = new StringBuilder();
                int time = times.pop();
                for (int k = 0; k < time; k++) {
                    repeatString.append(curString);
                }
                for (int j = 0; j < repeatString.length(); j++) str.push(repeatString.charAt(j));
            } else {
                str.push(s.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : str) ans.append(c);
        return ans.toString();
    }
}
