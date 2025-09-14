package core;

public class Cell {

    private Symbol symbol;

    public Cell () {
        this.symbol = Symbol.EMPTY;
    }

    public Cell (Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }


}
