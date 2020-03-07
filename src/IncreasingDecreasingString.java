import java.util.*;

public class IncreasingDecreasingString {
    public String sortString(String s) {
        if(s.length()==0) return s;

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt+1);
        }
        List<Character> chars = new ArrayList<>();
        for(char c:map.keySet()) chars.add(c);
        boolean ifReverse = false;
        while(sb.length()<s.length()){
            if(ifReverse){
                Collections.sort(chars, (a, b)->b-a);
            }else{
                Collections.sort(chars, (a,b)->a-b);
            }
            for(char c:chars){
                // System.out.println(c);
                if(map.get(c)>0) sb.append(c);
                map.put(c,map.get(c)-1);
            }
            ifReverse = !ifReverse;
        }
        return sb.toString();
    }
}
