package com.hz;

public class PlayerLevi implements TicTacToe {

        private final int width;
        private final int height;
        private String looseImage;
        private String victoryImage;

        public enum player { X, O }

        public PlayerLevi(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public void printBoard() {
            System.out.println("Lets play a game called TicTacToe ");

        }
        @Override
        public void acceptSymbol(int symbol) {

        }

        @Override
        public void accept(int[] state) {

        }

        @Override
        public void setNewState() {

        }

        @Override
        public int[] getChangedState() {
            return new int[0];
        }

        @Override
        public String[] getLooseImage() {
            return new String[]{looseImage};
        }

        @Override
        public String[] getVictoryImage() {

            return new String[]{victoryImage};
        }
}
