class Solution {
    public int totalNQueens(int n) {
        int[] count = new int[1];
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(board, 0, count);
        return count[0];
    }

    private void solve(char[][] board, int col, int[] count) {
        if (col == board.length) {
            count[0]++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 'Q';
                solve(board, col + 1, count);
                board[i][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        // Check if there is a queen in the same column
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check lower left diagonal
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
