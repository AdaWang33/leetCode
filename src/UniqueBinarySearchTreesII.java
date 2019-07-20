/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */

public class UniqueBinarySearchTreesII {
    public int numTrees(int n) {
        if (n == 0) return 0;
        return cntTree(n, new int[n + 1]);
    }

    public int cntTree(int n, int[] mem) {
        int ans = 0;

        // 边界条件
        if (n <= 1) return 1;
        if (mem[n] != 0) return mem[n];

        for (int i = 1; i <= n; i++) {
            int lnum = cntTree(i - 1, mem);
            int rnum = cntTree(n - i, mem);
            ans += lnum * rnum;
        }
        mem[n] = ans;
        return ans;
    }
}
