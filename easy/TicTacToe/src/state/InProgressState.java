package state;

import core.GameBoard;

public class InProgressState implements GameState {

    public void setState(GameBoard context) {
        context.setGameState(new WinnerState());
    }

}
