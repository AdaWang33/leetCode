public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                String a = s.substring(left, right);
                String b = s.substring(left+1, right+1);
                return a.equals(new StringBuilder(a).reverse().toString())||b.equals(new StringBuilder(b).reverse().toString());
            }
            left++;
            right--;
        }
        return true;
    }
}
