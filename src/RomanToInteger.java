import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> lookup = new HashMap<Character, Integer>();
        lookup.put('I', 1);
        lookup.put('V', 5);
        lookup.put('X', 10);
        lookup.put('L', 50);
        lookup.put('C', 100);
        lookup.put('D', 500);
        lookup.put('M', 1000);

        String idx = new String("IVXLCDM");
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            char cr = s.charAt(i+1);
            if (idx.indexOf(c) >= idx.indexOf(cr)) {
                ans += lookup.get(c);
            } else ans += -lookup.get(c);
        }
        ans += lookup.get(s.charAt(s.length() - 1));
    return ans;
    }
}
