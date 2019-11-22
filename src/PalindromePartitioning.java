import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) return res;

        generatePalindromePartitioning(res, new ArrayList<>(), s, 0);
        return res;
    }

    public void generatePalindromePartitioning(List<List<String>> res, List<String> tmp, String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s.substring(index, i + 1))) {
                tmp.add(s.substring(index, i + 1));
                generatePalindromePartitioning(res, tmp, s, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}
