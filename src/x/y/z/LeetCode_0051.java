package x.y.z;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_0051 {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return null;
        }
        // 棋盘
        char[][] board = new char[n][n];
        for (char[] chs : board) {
            Arrays.fill(chs, '.');
        }
        backtrack(board, 0);
        return result;

    }

    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            result.add(charsToString(board));
        }
        for (int col = 0; col < board[0].length; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            //回溯
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        //检查每一行中的该列
        for (char[] chs : board) {
            if (chs[col] == 'Q') {
                return false;
            }
        }
        //检查 / 对角线是否合法
        for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //检查 \ 对角线是否合法
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> charsToString(char[][] arr) {
        List<String> res = new ArrayList<>();
        for (char[] chs : arr) {
            res.add(String.valueOf(chs));
        }
        return res;
    }
}
