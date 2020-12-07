package com.hz;

// Introduce Null-Object
public class NoWinning extends WinningState {

    public NoWinning() {

        super("No Victory", -1, -1, -1);
    }

    @Override
    public boolean isAchieved() {
        return false;
    }
}
