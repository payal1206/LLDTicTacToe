package LLDTicTacToe;

import LLDTicTacToe.Model.Board;
import LLDTicTacToe.Model.Player;
import LLDTicTacToe.Model.PlayingPieceO;
import LLDTicTacToe.Model.PlayingPieceX;

import java.util.Deque;
import java.util.LinkedList;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        initialize();
    }
    public void initialize() {
        players =  new LinkedList<>();
        PlayingPieceX cross = new PlayingPieceX();
        PlayingPieceO zero = new PlayingPieceO();

    }
}
