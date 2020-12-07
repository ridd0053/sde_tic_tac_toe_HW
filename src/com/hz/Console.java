package com.hz;

public class Console {

    public static void print(int[] state) {

        String sep = "---+---+---";
        String line1 = String.format(" %s | %s | %s ", s(state[0]), s(state[1]), s(state[2]));
        String line2 = String.format(" %s | %s | %s ", s(state[3]), s(state[4]), s(state[5]));
        String line3 = String.format(" %s | %s | %s ", s(state[6]), s(state[7]), s(state[8]));

        printLine(line1);
        printLine(sep);
        printLine(line2);
        printLine(sep);
        printLine(line3);
    }

    private static String s(int symbol) {
        if(symbol < 0) return " ";

        return "" + symbol;
    }

    public static void printLine(String msg) {

        System.out.println(msg);
    }
}
