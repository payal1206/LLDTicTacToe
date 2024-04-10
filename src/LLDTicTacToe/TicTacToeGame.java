package LLDTicTacToe;

import LLDTicTacToe.Model.*;
import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        initialize();
    }
    public void initialize() {
        players =  new LinkedList<>();
        PlayingPieceX cross = new PlayingPieceX();
        Player player1 = new Player("Player1",cross);
        PlayingPieceO zero = new PlayingPieceO();
        Player player2 = new Player("Player2",zero);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }
    public String startGame(){
        boolean noWinner = true;
        while(noWinner){

            Player playerturn = players.removeFirst();

            gameBoard.printBoard();
            List<Pair<Integer,Integer>> freeSpaces = gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }
            System.out.println("PLayer:" + playerturn.name + "Enter row, column");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.valueOf(values[0]);
            int column = Integer.valueOf(values[1]);

            //place the piece
            boolean addedSucess = gameBoard.addPiece(row,column,playerturn.playingPiece);
            if(!addedSucess){
                System.out.println("Incorrect Position, try again!");
                players.addFirst(playerturn);
                continue;
            }
            players.addLast(playerturn);

            boolean isWinner = isThereWinner(row,column,playerturn.playingPiece.pieceType);
            if(isWinner){
                return playerturn.name;
            }
        }
        return "tie";
    }
    public boolean isThereWinner(int row, int column, PieceType pieceType){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDigonalMatch = true;

        for (int i = 0; i < gameBoard.size; i++) {
            if( gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        for (int i = 0; i < gameBoard.size; i++) {
            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }
        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }
        for (int i = 0, j = gameBoard.size - 1 ; i < gameBoard.size; i++, j--) {
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDigonalMatch = false;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDigonalMatch;
    }
}
