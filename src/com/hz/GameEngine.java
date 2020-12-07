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

        VictoryState victoryState = this.getVictoryState();
        if(victoryState.isVictorious()) {

            String symbol = getPlayerSymbol(player);
            String name = player.getPlayerName();
            String winningType = victoryState.getName();
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

    private VictoryState getVictoryState() {

        VictoryState[] victoryStates = new VictoryState[8];

        victoryStates[0] = new VictoryState("First row",
                this.state[0], this.state[1], this.state[2]);
        victoryStates[1] = new VictoryState("Second row",
                this.state[3], this.state[4], this.state[5]);
        victoryStates[2] = new VictoryState("Third row",
                this.state[6], this.state[7], this.state[8]);

        victoryStates[3] = new VictoryState("First column",
                this.state[0], this.state[3], this.state[6]);
        victoryStates[4] = new VictoryState("Second column",
                this.state[1], this.state[4], this.state[7]);
        victoryStates[5] = new VictoryState("Third column",
                this.state[2], this.state[5], this.state[8]);


        victoryStates[6] = new VictoryState("First diagonal",
                this.state[0], this.state[4], this.state[8]);
        victoryStates[7] = new VictoryState("Second diagonal",
                this.state[6], this.state[4], this.state[2]);

        for(VictoryState state : victoryStates) {

            if(state.isVictorious()) return state;
        }

        return new NoVictory();
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