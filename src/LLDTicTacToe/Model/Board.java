package LLDTicTacToe.Model;

import java.net.Inet4Address;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][]board;

    public  Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }
    public boolean addPiece(int row,int colunm,PlayingPiece playingPiece){
        if(board[row][colunm] != null){
           return false;
        }
        board[row][colunm] = playingPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells(){
        List<Pair<Integer, Integer>> freeCellls = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    Pair<Integer, Integer> rowColumn = new Pair<>(i, j);
                    freeCellls.add(rowColumn);
                }
            }
        }
        return freeCellls;
    }
    public void printBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(board[i][j]);
            }

        }
    }
}

