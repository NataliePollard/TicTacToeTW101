package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private Board board;

    @Before
    public void setup() {

        board = new Board();
        board.generateBoard();
    }

    @Test
    public void shouldReturnAnEmptyBoardWhenBoardIsEmpty() throws Exception {
        String boardString =
                ("  |   |  \n" +
                 "---------\n" +
                 "  |   |  \n" +
                 "---------\n" +
                 "  |   |  \n");
        assertEquals(board.generateBoard(), boardString);
    }

    @Test
    public void shouldReturnABoardWithXAtPostionOneWhenBoardWhenBoardHasXAtPotitionOne() throws Exception {
        String boardString = (" X|   |  \n" +
                        "---------\n" +
                        "  |   |  \n" +
                        "---------\n" +
                        "  |   |  \n");
        board.addXOrO(1,'X');
        assertEquals(board.generateBoard(), boardString);
    }

    @Test
    public void shouldReturnABoardWithXAtPostionThreeWhenBoardWhenBoardHasXAtPotitionThree() throws Exception {
        String boardString = ("  |   |X \n" +
                "---------\n" +
                "  |   |  \n" +
                "---------\n" +
                "  |   |  \n");
        board.addXOrO(3,'X');
        assertEquals(board.generateBoard(), boardString);
    }

    @Test
    public void shouldReturnABoardWithOAtPostionSixWhenBoardWhenBoardHasOAtPotitionSix() throws Exception {
        String boardString = ("  |   |X \n" +
                "---------\n" +
                "  |   |O \n" +
                "---------\n" +
                "  |   |  \n");
        board.addXOrO(3,'X');
        board.addXOrO(6,'O');
        assertEquals(board.generateBoard(), boardString);
    }

    @Test
    public void shouldReturnTrueWhenLocationTaken() {
        board.addXOrO(3,'X');
        assertTrue(board.isTaken(3));

    }

    @Test
    public void shouldReturnFalseWhenLocationNotTaken() {
        board.addXOrO(3,'X');
        assertFalse(board.isTaken(4));

    }
}