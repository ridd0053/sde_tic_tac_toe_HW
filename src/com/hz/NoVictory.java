package com.hz;

public class NoVictory extends VictoryState {

    public NoVictory() {

        super("No Victory", -1, -1, -1);
    }

    @Override
    public boolean isVictorious() {
        return false;
    }
}
