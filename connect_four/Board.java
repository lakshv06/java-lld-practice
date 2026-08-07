package connect_four;

import connect_four.enums.DiscColor;

public class Board {
    private int rows;
    private int columns;
    private DiscColor[][] board;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new DiscColor[rows][columns];
    }

    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }

    public boolean canPlace(int column){
        if(column<0 || column>=columns){
            return false;
        }
        return board[0][column] == null;
    }

    public int placeDisc(int column, DiscColor discColor){
        if(!canPlace(column)){
            return -1;
        }
        for(int i = rows-1; i>=0; i--){
            if(board[i][column]==null){
                board[i][column] = discColor;
                return i;
            }
        }
        return -1;
    }

    public boolean isFull(){
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                if(board[i][j] == null){
                    return false;
                }
            }       
        }
        return true;
    }

    public DiscColor getCell(int row, int column){
        if(row<0 || row>=rows || column<0 || column>=columns){
            throw new IllegalArgumentException("Invalid position.");
        }
        return board[row][column];
    }

    public boolean checkWin(int row, int column, DiscColor discColor){
        if(row<0 || column<0 || row>=rows || column>=columns){
            return false;
        }
        if(board[row][column] != discColor){
            return false;
        }
        int[][]dirs = {{0,1},{1,0},{1,1},{1,-1}};

        for(int []dir: dirs){
            int count = 1;
            count+= countInDirection(row, column, dir[0], dir[1], discColor);
            count+= countInDirection(row, column, -dir[0], -dir[1], discColor);
            if(count>=4){
                return true;
            }
        }
        return false;
    }

    private int countInDirection(int row, int column, int rowDir, int colDir, DiscColor discColor){
        int count = 0;
        int r = row + rowDir;
        int c = column + colDir;

        while(r>=0 && r<rows && c>=0 && c<columns && board[r][c] == discColor){
            count++;
            r+=rowDir;
            c+=colDir;
        }
        return count;
    }
}
