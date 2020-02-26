public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] chars = new int[26];
        int maxCnt = 0;
        char maxCntChar = 'a';
        for(char c:S.toCharArray()){
            chars[c-'a']++;
            if(maxCnt<chars[c-'a']){
                maxCnt = chars[c-'a'];
                maxCntChar = c;
            }
        }
        boolean exist =  maxCnt<=(S.length()+1)/2;
        if(!exist) return "";

        char[] res = S.toCharArray();
        int idx = 0;
        while(maxCnt-->0){
            res[idx] = maxCntChar;
            idx+=2;
        }
        chars[maxCntChar-'a']=0;

        for(int i=0;i<26;i++){
            while(chars[i]>0){
                if(idx>=S.length()) idx=1;
                res[idx] = (char)(i+'a');
                chars[i]--;
                idx+=2;
            }
        }
        return String.valueOf(res);
    }
}
