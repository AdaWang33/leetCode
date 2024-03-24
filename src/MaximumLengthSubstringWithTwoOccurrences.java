import java.util.HashMap;

public class MaximumLengthSubstringWithTwoOccurrences {
    public int maximumLengthSubstring(String s) {
        int i=-1, j=0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(;j<s.length();j++) {
            char curChar = s.charAt(j);
            int curCnt = map.getOrDefault(curChar, 0);

            if(++curCnt==3) {
                while(s.charAt(++i)!=curChar) {
                    char pastChar = s.charAt(i);
                    int passCnt = map.get(pastChar);
                    map.put(pastChar, --passCnt);
                }
            } else {
                map.put(curChar, curCnt);
            }
            res = Math.max(res, j-i);            
        }

        return res;
        
    }
}
