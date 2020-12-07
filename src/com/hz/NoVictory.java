package com.hz;

// Introduce Null-Object
public class NoVictory extends VictoryState {

    public NoVictory() {

        super("No Victory", -1, -1, -1);
    }

    @Override
    public boolean isVictorious() {
        return false;
    }
}
