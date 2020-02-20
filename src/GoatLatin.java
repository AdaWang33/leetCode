import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    Set<Character> set = new HashSet<>();
    public String toGoatLatin(String S) {
        if(S==null||S.length()==0) return S;
        String res="";

        for (char c : "aeiouAEIOU".toCharArray()) set.add(c);
//        set.add('a');
//        set.add('A');
//        set.add('e');
//        set.add('E');
//        set.add('i');
//        set.add('I');
//        set.add('o');
//        set.add('O');
//        set.add('u');
//        set.add('U');

        String[] str = S.split("\\s+");
        for(int i=0;i<str.length;i++){
            res+=helper(str[i], i);
            res+=" ";
        }
        res=res.substring(0,res.length()-1);
        return res;
    }

    public String helper(String str, int index){
        if(set.contains(str.charAt(0))){
            str += "ma";
        }else{
            char c = str.charAt(0);
            str = str.substring(1);
            str+=c;
            str+="ma";
        }

        while(index-->=0){
            str+="a";
        }
        return str;
    }
}
