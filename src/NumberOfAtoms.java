import java.util.*;

public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stk = new Stack<>();
        Map<String, Integer> map = new HashMap<>();

        StringBuilder ans = new StringBuilder();
        if (formula.length() == 0) return ans.toString();

        int n = formula.length(), i = 0;
        while (i < n) {
            char c = formula.charAt(i);
            i++;
            if (c == '(') {
                stk.push(map);
                map = new HashMap<>();

            } else if (c == ')') {
                int val = 0;
                while (i < n && Character.isDigit(formula.charAt(i)))
                    val = val * 10 + formula.charAt(i++) - '0';

                if (val == 0) val = 1;
                if (!stk.isEmpty()) {
                    Map<String, Integer> temp = map;
                    map = stk.pop();
                    for (String s : temp.keySet()) {
                        map.put(s, map.getOrDefault(s, 0) + temp.get(s) * val);
                    }
                }
            } else {
                int start = i - 1;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String s = formula.substring(start, i);
                int val = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) val = val * 10 + formula.charAt(i++) - '0';
                if (val == 0) val = 1;
                map.put(s, map.getOrDefault(s, 0) + val);
            }
        }

        List sortedKeys = new ArrayList(map.keySet());
        Collections.sort(sortedKeys);
        for (i = 0; i < sortedKeys.size(); i++) {
            ans.append(sortedKeys.get(i));
            if (map.get(sortedKeys.get(i)) != 1) ans.append(map.get(sortedKeys.get(i)));
        }
        return ans.toString();
    }
}
