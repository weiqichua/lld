package core;

import state.IdleState;
import state.WinnerState;
import state.GameState;

public class GameBoard {

    // A 2D array of cells
    private Cell[][] board = new Cell[3][3];
    // Separate class to check the current state of the game
    private GameState gameState;


    public GameBoard () {
        this.gameState = new IdleState();
    }


    // Methods

    // - initialiseNewBoard
    public void initialiseNewBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public Cell[][] getBoard() {
        return board;
    }

    // helper method
    private boolean checkIsValidMove(int row, int col) {
        return 0 <= row && row < 3 && 0 <= col && col < 3;
    }

    public Cell getCell(int row, int col) {
        if (checkIsValidMove(row, col)) {
            return board[row][col];
        }
        return null;
    }

    // - update board
    public void updateBoard(int row, int col, Cell symbol) {

        if (!checkIsValidMove(row, col) ||  this.getCell(row, col).getSymbol() != Symbol.EMPTY) {
            System.out.print("Cell taken, invalid move!");
            return;
        }

        board[row][col] = symbol;

    }


    // - set state
    public void setGameState(GameState newState) {
        this.gameState = newState;
    }





}
