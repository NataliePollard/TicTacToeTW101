package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToeApp {
    private Board board;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public TicTacToeApp(Board board, PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.board = board;
        this.bufferedReader = bufferedReader;
    }

    public void runGame() throws IOException {
        printCurrentBoard();
        promptPlayer(1);

        int inputNumber = getUserInput();
        board.addXOrO(inputNumber,'X');

        printCurrentBoard();

        promptPlayer(2);
        inputNumber = getUserInput();
        while(board.isTaken(inputNumber)) {
            printStream.println("Location already taken");
            promptPlayer(2);
            inputNumber = getUserInput();
        }
        board.addXOrO(inputNumber,'O');

        printCurrentBoard();
    }

    private int getUserInput() throws IOException {
        String input = bufferedReader.readLine();
        return Integer.parseInt(input);
    }

    private void printCurrentBoard() {
        String currentBoard = board.generateBoard();
        printStream.println(currentBoard);
    }


    private void promptPlayer(int playerNumber) {
        String prompt = "Player " + playerNumber + ": Enter a number between 1 and 9 to indicate where you wish to move";
        printStream.println(prompt);
    }
}
