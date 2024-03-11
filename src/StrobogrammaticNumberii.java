import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the strobogrammatic numbers that are of length n. You may return the answer in any order.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 

Example 1:

Input: n = 2
Output: ["11","69","88","96"]
Example 2:

Input: n = 1
Output: ["0","1","8"]
 

Constraints:

1 <= n <= 14
 */

public class StrobogrammaticNumberii {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n%2==1) {
            res.add("0");
            res.add("1");
            res.add("8");
        } else {
            res.add("");
        }
        if(n==1) return res;

        List<String> newRes;
        while(n>1) {
            newRes = new ArrayList<>();
            for(String str:res) {
                newRes.add("1" + str + "1");
                newRes.add("8" + str + "8");
                newRes.add("6" + str + "9");
                newRes.add("9" + str + "6");
                if(n>3) {
                    newRes.add("0" + str + "0");
                }
            }
            n-=2;
            res = newRes;
        }
        return res;
    }
    
}
