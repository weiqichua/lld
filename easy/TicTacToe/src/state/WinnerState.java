package state;

import core.GameBoard;

public class WinnerState implements GameState {

    public void setState(GameBoard context) {
        context.setGameState(new InProgressState());
    }


}
