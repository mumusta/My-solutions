class Solution {
    
    int[][] grid = new int[10][10];

    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i ++)
            for  (int ii = 0; ii < 9; ii ++)
                if (Character.isDigit(board[i][ii]))
                    grid[i][ii] = Character.getNumericValue(board[i][ii]);

        for (int ii = 0; ii < 9; ii ++){

            int cw[] = new int[10];

            for (int i = 0; i < 9; i ++)
                cw[grid[i][ii]]++;

            for (int x = 1; x < 10; x ++)
                if (cw[x] > 1)
                    return false;
        }

        for (int i = 0; i < 9; i ++){

            int cw[] = new int[10];

            for (int ii = 0; ii < 9; ii ++)
                cw[grid[i][ii]]++;

            for (int x = 1; x < 10; x ++)
                if (cw[x] > 1)
                    return false;
        }

        for (int x = 0; x < 9; x += 3){

            for (int xx = 0; xx < 9; xx += 3){

                int cw[] = new int[10];

                for (int i = x; i < (x + 3); i ++)
                    for (int ii = xx; ii < (xx + 3); ii ++)
                        cw[grid[i][ii]]++;

                for (int z = 1; z < 10; z ++)
                    if (cw[z] > 1)
                        return false;
            }
        }
            
        return true;
    }
}
