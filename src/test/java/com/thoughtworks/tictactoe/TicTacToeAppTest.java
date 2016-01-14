package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TicTacToeAppTest {

    private PrintStream printStream;
    private TicTacToeApp ticTacToeApp;
    private Board board;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {

        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        ticTacToeApp = new TicTacToeApp(board, printStream, bufferedReader);
        when(bufferedReader.readLine()).thenReturn("4");
    }


    @Test
    public void shouldPromptUserWhenItStarts() throws IOException {
        ticTacToeApp.runGame();
        String prompt = "Enter a number between 1 and 9 to indicate where you wish to move";
        verify(printStream).println(prompt);
    }

    @Test
    public void shouldPrintBoardWhenStarts() throws IOException {
        ticTacToeApp.runGame();
        verify(board).generateBoard();
    }

    @Test
    public void shouldTakeInputFromUser() throws IOException {
        ticTacToeApp.runGame();
        verify(board).addXOrO(4,'X');
    }

    @Test
    public void shouldPrintBoardWithXWhen() throws IOException {
        ticTacToeApp.runGame();
        verify(board).addXOrO(4,'X');
        //verify()
    }

    @Test
    public void shouldPromptWhenLocationTaken() throws IOException {
        ticTacToeApp.runGame();
        when(bufferedReader.readLine()).thenReturn("4");
        verify(printStream).println("Location already taken");
    }


}
