package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    public void whenBishopBlackIsOnPosition() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell position = bishopBlack.position();
        assertThat(position).isEqualTo(Cell.C1);
    }

    @Test
    public void whenBishopBlackCopy() {
        Figure bishopBlack = new BishopBlack(Cell.H6);
        Figure clonedObject = bishopBlack.copy(Cell.H6);
        Assertions.assertEquals(clonedObject.position(), bishopBlack.position());
    }

    @Test
    public void whenBishopBlackWay() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assertions.assertArrayEquals(expected, result);
    }

}