class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c<9; c++) {
                if(board[r][c] == '.') continue;
                // int num = Integer.parseInt(""+board[r][c]);
                int num = board[r][c] - '0';
                if(num > 9 || num <= 0) return false;
                String rowVal = num + "_in_row_" + r;
                String colVal = num + "_in_col_" +c;
                String boxVal = num + "_in_box_" + r/3 + "_" + c/3;
                if(seen.contains(rowVal) || seen.contains(colVal) || seen.contains(boxVal)) {
                    return false;
                }
                seen.add(rowVal);
                seen.add(colVal);
                seen.add(boxVal);
            }
        }
        return true;
    }
}
