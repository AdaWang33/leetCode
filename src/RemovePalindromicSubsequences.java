public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        // We can delete all characters 'a' in the 1st operation,
        // and then all characters 'b' in the 2nd operation.
        // So return 2 in this case
        if(s.equals("")) return 0;
        if(new StringBuilder(s).reverse().toString().equals(s)) return 1;
        return 2;
    }
}
