package com.hz;

import com.hz.players.TicTacToe;

public class GameEngine {

    private int[] state;
    private int round;

    public GameEngine() {
        this.state = new int[9];
    }

    public void setPlayerOne(TicTacToe playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayerTwo(TicTacToe playerTwo) {
        this.playerTwo = playerTwo;
    }

    private TicTacToe playerOne;
    private TicTacToe playerTwo;


    public void startGame() {

        this.setInitState();

        this.printPlayerInfo();
        this.printState();

        // game loop
        while(true) {

            this.round++;

            performPlayerMove(this.playerOne);

            performPlayerMove(this.playerTwo);
        }
    }

    private void printPlayerInfo() {

        String playerOneSymbol = getPlayerSymbol(this.playerOne);
        String playerTwoSymbol = getPlayerSymbol(this.playerTwo);

        String msg = String.format("Player %s: '%s' vs. Player %s: '%s'",
                playerOneSymbol, this.playerOne.getPlayerName(),
                playerTwoSymbol, this.playerTwo.getPlayerName());
        Console.print(msg);
    }

    private String getPlayerSymbol(TicTacToe playerOne) {
        return Console.s(playerOne.getSymbol());
    }


    private void performPlayerMove(TicTacToe player) {
        playMove(player);
        printState();

        WinningState winningState = this.getWinningState();
        if(winningState.isAchieved()) {

            String symbol = getPlayerSymbol(player);
            String name = player.getPlayerName();
            String winningType = winningState.getName();
            String msg = String.format("Player %s won with '%s'! Congratulations %s",
                    symbol, winningType, name);
            Console.print(msg);

            System.exit(0);
        }
    }


    private void playMove(TicTacToe player) {

        player.accept(this.state);
        player.setNewState();
        this.state = player.getChangedState();
    }

    private WinningState getWinningState() {

        WinningState[] winningStates = new WinningState[8];

        winningStates[0] = new WinningState("First row",
                this.state[0], this.state[1], this.state[2]);
        winningStates[1] = new WinningState("Second row",
                this.state[3], this.state[4], this.state[5]);
        winningStates[2] = new WinningState("Third row",
                this.state[6], this.state[7], this.state[8]);

        winningStates[3] = new WinningState("First column",
                this.state[0], this.state[3], this.state[6]);
        winningStates[4] = new WinningState("Second column",
                this.state[1], this.state[4], this.state[7]);
        winningStates[5] = new WinningState("Third column",
                this.state[2], this.state[5], this.state[8]);


        winningStates[6] = new WinningState("First diagonal",
                this.state[0], this.state[4], this.state[8]);
        winningStates[7] = new WinningState("Second diagonal",
                this.state[6], this.state[4], this.state[2]);

        for(WinningState winningState : winningStates) {

            if(winningState.isAchieved()) return winningState;
        }

        return new NoWinning();
    }

    private void printState() {
        Console.print("Round #" + this.round);
        Console.print(state);
    }

    private void setInitState() {
        this.state[0] = -1;
        this.state[1] = -1;
        this.state[2] = -1;
        this.state[3] = -1;
        this.state[4] = -1;
        this.state[5] = -1;
        this.state[6] = -1;
        this.state[7] = -1;
        this.state[8] = -1;

        this.round = 0;

        this.playerOne.setSymbol(0);
        this.playerTwo.setSymbol(1);
    }
}