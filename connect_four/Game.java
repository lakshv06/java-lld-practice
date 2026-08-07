package connect_four;

import connect_four.enums.GameState;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Player winner;
    private GameState gameState;

    public Game(int rows, int columns, Player player1, Player player2) {
        this.board = new Board(rows, columns);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
    }

    public boolean makeMove(Player player, int column){
        if(gameState != GameState.IN_PROGRESS || player != currentPlayer){
            System.out.println("Invalid move. Either the game is over or it's not your turn.");
            return false;
        }
        int row = board.placeDisc(column, player.getColor());
        
        if(row==-1){
            System.out.println("Invalid move. Column " + column + " is full or out of bounds.");
            return false;
        }

        if(board.checkWin(row, column, player.getColor())){
            gameState = GameState.WON;
            winner = player;
            System.out.println("Player " + player.getName() + " wins!");
        } else if(board.isFull()){
            gameState = GameState.DRAW;
            System.out.println("The game is a draw!");
        } else{
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
            System.out.println("Next turn: " + currentPlayer.getName() + " (" + currentPlayer.getColor() + ")");
        }
        return true;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Board getBoard(){
        return board;
    }

}

