class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rowCheck = new int[9];
        int[] colCheck = new int[9];
        int[] boxCheck = new int[9];

        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                if(board[r][c] == '.') continue;
                int val = board[r][c] - '1';

                if((rowCheck[r] & (1 << val)) > 0 ||
                    (colCheck[c] & (1 << val)) > 0 ||
                    (boxCheck[(r/3) * 3 + (c/3)] & (1 << val)) > 0)
                     {
                        return false;
                    }
                    rowCheck[r] |= (1 << val);
                    colCheck[c] |= (1 << val);
                    boxCheck[(r/3) *3 + (c/3)] |= (1 << val);
                    
            }
        }
        return true;
    }
}
