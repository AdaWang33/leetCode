public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isAlphabetic(c)){
                sb.append(Character.toLowerCase(c));
            }else if(c>='0'&&c<='9'){
                sb.append(c);
            }
        }

        return helper(sb.toString());

    }

    public boolean helper(String s){
        if(s==null||s.length()==0) return true;

        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
