import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        int ans = 0;
//        HashMap<Character, Integer> lookup = new HashMap<Character, Integer>();
//        lookup.put('I', 1);
//        lookup.put('V', 5);
//        lookup.put('X', 10);
//        lookup.put('L', 50);
//        lookup.put('C', 100);
//        lookup.put('D', 500);
//        lookup.put('M', 1000);

        String chara = new String("IVXLCDM");
        int[] number = new int[]{1,5,10,50,100,500,1000};
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            char cr = s.charAt(i+1);
            if (chara.indexOf(c) >= chara.indexOf(cr)) {
                ans += number[chara.indexOf(c)];
            } else ans -= number[chara.indexOf(c)];;
        }
        ans += number[chara.indexOf(s.charAt(s.length() - 1))];
    return ans;
    }
}
