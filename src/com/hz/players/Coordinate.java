package com.hz.players;

public class Coordinate implements CoordinateState{
    @Override
    public int coordinate(int[] state, int symbol) {

        // 'First comes, first served' algorithm
        for (int i = 0; i < 9; i++) {
            int coordinate = state[i];

            if (coordinate == -1) {
                state[i] = symbol;

                break;
            }
        }
        return symbol;
    }
}
