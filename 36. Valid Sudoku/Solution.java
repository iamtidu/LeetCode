class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowSeen = new boolean[9][10];
        boolean[][] colSeen = new boolean[9][10];
        boolean[][] boxSeen = new boolean[9][10];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    
                    // Check row
                    if (rowSeen[i][num]) return false;
                    rowSeen[i][num] = true;
                    
                    // Check column
                    if (colSeen[j][num]) return false;
                    colSeen[j][num] = true;
                    
                    // Check sub-box
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    if (boxSeen[boxIndex][num]) return false;
                    boxSeen[boxIndex][num] = true;
                }
            }
        }
        
        return true;
    }
}
