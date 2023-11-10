package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenImpossibleMoveException()
        throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
           bishopBlack.way(Cell.D3);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to D3");
    }

    @Test
    public void whenOccupiedCellException() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure secondBishopBlack = new BishopBlack(Cell.D2);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(secondBishopBlack);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.C1, Cell.G5);
        });
        assertThat(exception.getMessage()).
                isEqualTo("This figure can't jump over the other pieces");
    }
}