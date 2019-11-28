/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = 0;
        int n = 0;
        boolean[] res = new boolean[1];
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && findNextChar(board, i, j, word, 0, used)) return true;
            }
        }
        return false;
    }

    public boolean findNextChar(char[][] board, int m, int n, String word, int index, boolean[][] used) {
        if (index == word.length()) {
            return true;
        }
        if (m < 0 || n < 0 || m >= board.length || n >= board[0].length || board[m][n] != word.charAt(index) || used[m][n]) {
            return false;
        }

        used[m][n] = true;
        if (findNextChar(board, m - 1, n, word, index + 1, used) || findNextChar(board, m, n - 1, word, index + 1, used) || findNextChar(board, m + 1, n, word, index + 1, used) || findNextChar(board, m, n + 1, word, index + 1, used)) {
            return true;
        }
        used[m][n] = false;
        return false;
    }
}
