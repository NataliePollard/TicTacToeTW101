package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        Board board = new Board();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TicTacToeApp app = new TicTacToeApp(board, printStream, bufferedReader);
        app.runGame();
    }
}
