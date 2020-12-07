package com.hz.players;

public interface TicTacToe {

    // init
    void acceptSymbol(int symbol);


    // game loop
    void accept(int[] state);

    void setNewState();

    int[] getChangedState();
    // game loop end

    // graphics
    String[] getLooseImage();

    String[] getVictoryImage();
}
