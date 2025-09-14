package tests;

import core.Cell;
import core.GameBoard;
import core.Symbol;
import core.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private GameBoard gameBoard;

    @BeforeEach
    public void setUp() {
        gameBoard = new GameBoard();
    }

    @Test
    public void updateCell() {
        gameBoard.updateBoard(1, 1, new Cell(Symbol.X));
        assertEquals(new Cell(Symbol.X), gameBoard.getBoard()[1][1]);
    }

    @Test
    public void testInitialiseNewGame() {
        gameBoard.updateBoard(1, 1, new Cell(Symbol.X));
        gameBoard.initialiseNewBoard();
        assertEquals(gameBoard.getBoard()[1][1], new Cell(Symbol.EMPTY));
    }

}
