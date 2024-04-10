package LLDTicTacToe.Model;

public class Board {
    public int size;
    public PlayingPiece[][]board;

    public  Board(){
        this.size = size;
        board = new PlayingPiece[size][size];
    }
}

