package com.hz.players;

public interface TicTacToe {

    String getPlayerName();

    // init
    void setSymbol(int symbol);
    int getSymbol();

    // game loop
    void accept(int[] state);

    void setNewState();

    int[] getChangedState();
    // game loop end
}
