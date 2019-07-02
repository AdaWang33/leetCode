public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // 砍尾巴大法，有趣！
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) return strs[0];

        // find the shortest string first
        int lens = Integer.MAX_VALUE;
        int idx = -1;
        String sub = "";

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < lens) {
                lens = strs[i].length();
                idx = i;
                sub = strs[i];
            }
        }


        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(sub) != 0) {
                sub = sub.substring(0, sub.length() - 1);
            }
        }
        return sub;
    }
}
