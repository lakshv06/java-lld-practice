package connect_four;

import connect_four.enums.DiscColor;

public class Main {
    public static void main (String[] args){
        Player player1 = new Player("Laksh", DiscColor.YELLOW);
        Player player2 = new Player("Lakshya", DiscColor.RED);
        Game game = new Game(7, 7, player1, player2);
        game.makeMove(player1, 2);
        // game.makeMove(player1, 3);
        game.makeMove(player2, 4);

        game.makeMove(player1, 2);
        game.makeMove(player2, 4);
        
        game.makeMove(player1, 2);
        game.makeMove(player2, 4);
        
        game.makeMove(player1, 2);
        game.makeMove(player2, 4);
    }
}
