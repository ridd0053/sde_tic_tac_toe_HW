package com.hz;

public class Console {

    public static void print(int[] state) {

        String sep = "---+---+---";
        String line1 = String.format(" %s | %s | %s ", s(state[0]), s(state[1]), s(state[2]));
        String line2 = String.format(" %s | %s | %s ", s(state[3]), s(state[4]), s(state[5]));
        String line3 = String.format(" %s | %s | %s ", s(state[6]), s(state[7]), s(state[8]));

        print(line1);
        print(sep);
        print(line2);
        print(sep);
        print(line3);
    }

    public static void print(String msg) {

        System.out.println(msg);
    }

    public static void print(String[] msgs) {

        for(String msg : msgs)
            System.out.println(msg);
    }

    public static String s(int symbol) {
        if(symbol < 0) return " ";

        if(symbol == 0) return "O";

        return "X";
    }


}
