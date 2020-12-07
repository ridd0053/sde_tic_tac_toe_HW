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

        // print start state
        this.printState();

        // game loop
        while(true) {

            this.round++;

            playMove(this.playerOne);
            printState();

            if(this.isFinished()) {
                this.playerOne.getVictoryImage();
                this.playerTwo.getLooseImage();

                System.exit(0);
            }

            playMove(this.playerTwo);
            printState();

            if(this.isFinished()) {
                this.playerTwo.getVictoryImage();
                this.playerOne.getLooseImage();

                System.exit(0);
            }

        }
    }

    private void playMove(TicTacToe player) {

        player.accept(this.state);
        player.setNewState();
        this.state = player.getChangedState();
    }

    private boolean isFinished() {

        // first row
        return this.state[0] == this.state[1]
                && this.state[1] == this.state[2]
                && this.state[0] != -1;

        // second row

        // third row

        // first column

        // second column

        // third column

        // strike
    }

    private void printState() {
        Console.printLine("Round #" + this.round);
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

        this.playerOne.acceptSymbol(0);
        this.playerTwo.acceptSymbol(1);

    }

}
