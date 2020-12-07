package com.hz.players;

import com.hz.players.TicTacToe;

public class DummyPlayer implements TicTacToe {

    private int symbol;

    private int[] state;

    @Override
    public void acceptSymbol(int symbol) {
        this.symbol = symbol;
    }

    @Override
    public void accept(int[] state) {

        this.state = state;
    }

    @Override
    public void setNewState() {

        this.state[0] = this.symbol;
    }

    @Override
    public int[] getChangedState() {
        return this.state;
    }

    @Override
    public String[] getLooseImage() {
        return new String[]{ "Too bad" };
    }

    @Override
    public String[] getVictoryImage() {
        return new String[]{ "YES!!" };
    }
}
