import java.util.Arrays;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        // String[] cur = new String[words.length];
        // for(int i=0;i<words.length;i++) cur[i] = words[i];
        String[] cur = Arrays.copyOf(words, words.length);

        Arrays.sort(words, (a, b)->{
            if(a.equals(b)) return 0;
            int len = Math.min(a.length(),b.length());
            for(int i=0;i<len;i++){
                if(a.charAt(i)!=b.charAt(i)) return order.indexOf(a.charAt(i))-order.indexOf(b.charAt(i));
            }
            if(a.length()>len) return 1;
            else return -1;
        });

        for(int i=0;i<words.length;i++){
            if(words[i]!=cur[i]) return false;
        }
        return true;
    }
}
