import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
 * <p>
 * Here are the rules of Tic-Tac-Toe:
 * <p>
 * Players take turns placing characters into empty squares (" ").
 * The first player A always places "X" characters, while the second player B always places "O" characters.
 * "X" and "O" characters are always placed into empty squares, never on filled ones.
 * The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark their respective character in the order in which A and B play.
 * <p>
 * Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play return "Pending".
 * <p>
 * You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.
 */

public class FindWinnerOnATicTacToeGame {
    public String tictactoe(int[][] moves) {
        boolean[][] A = new boolean[3][3];
        boolean[][] B = new boolean[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                A[moves[i][0]][moves[i][1]] = true;
            } else B[moves[i][0]][moves[i][1]] = true;
        }

        // check who wins first
        // check horizontal
        for (int i = 0; i < 3; i++) {
            if (A[i][0] == true && A[i][1] == true && A[i][2] == true) return "A";
            if (B[i][0] == true && B[i][1] == true && B[i][2] == true) return "B";
        }

        // check vertical
        for (int j = 0; j < 3; j++) {
            if (A[0][j] == true && A[1][j] == true && A[2][j] == true) return "A";
            if (B[0][j] == true && B[1][j] == true && B[2][j] == true) return "B";
        }

        // check diagonal
        if ((A[0][0] == true && A[1][1] == true && A[2][2] == true) || A[0][2] == true && A[1][1] == true && A[2][0] == true)
            return "A";
        if ((B[0][0] == true && B[1][1] == true && B[2][2] == true) || B[0][2] == true && B[1][1] == true && B[2][0] == true)
            return "B";

        if (moves.length == 9) return "Draw";
        else return "Pending";
    }
}
