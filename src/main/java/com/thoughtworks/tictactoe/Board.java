package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Board {
    private int boardSize = 3;
    private char[][] boardArray = new char[boardSize][boardSize];

    public Board () {

        for(int i = 0; i < boardArray[0].length; i++) {
            for(int j = 0; j < boardArray[i].length; j++)
                boardArray[i][j] = ' ';
        }
    }
    public String generateBoard() {
        String board = "";
        board +=generateBoardRow(0);
        board += "---------\n";
        board +=generateBoardRow(1);
        board += "---------\n";
        board +=generateBoardRow(2);
        return board;

    }

    private String generateBoardRow(int row) {
    return String.format(" %c| %c |%c \n", boardArray[row][0], boardArray[row][1], boardArray[row][2]);
    }

    public void addXOrO(int inputNumber, char xOrO) {
        int col = (inputNumber-1) % 3;
        int row = (inputNumber-1) / 3;
        boardArray[row][col] = xOrO;
    }

    public boolean isTaken(int inputNumber) {
        int col = (inputNumber-1) % 3;
        int row = (inputNumber-1) / 3;
        return (boardArray[row][col] != ' ');
    }
}


