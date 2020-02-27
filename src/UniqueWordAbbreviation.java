public class UniqueWordAbbreviation {
    // Set<String> dict;
    String[] dict;
    public UniqueWordAbbreviation(String[] dictionary) {
        // dict = new HashSet<>();
        // for(String str:dictionary)  dict.add(str);
        dict = dictionary;
    }
    // public String helper(String str){
    //     if(str==null||str.length()<=2) return str;
    //     String res = str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
    //     return res;
    // }

    public boolean isUnique(String word) {
        for(String str:dict){
            if(str.equals(word)) continue;

            int m = word.length();
            int n = str.length();
            if(m==n && word.charAt(0)==str.charAt(0) && word.charAt(m-1)==str.charAt(n-1)) return false;
        }
        return true;
    }
}
