package com.hz.players;

public class NewPlayer implements TicTacToe{
    private int symbol;
    private int[] state;
    private CoordinateState cstate = new Coordinate();
    @Override
    public String getPlayerName() {
        return "Ilse";
    }

    @Override
    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    @Override
    public int getSymbol() {
        return this.symbol;
    }

    @Override
    public void accept(int[] state) {
        this.state = state;
    }

    @Override
    public void setNewState() {

    cstate.coordinate(this.state, this.symbol);

    }

    @Override
    public int[] getChangedState() {
       return this.state;
    }
}
