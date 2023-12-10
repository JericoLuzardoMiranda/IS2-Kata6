package tests;

import software.ulpgc.kata6.Board;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTest {

    public static class Cases {
        public static final String board_1x1_all_dead_cells = ".";
        public static final String board_1x1_with_alive_cell = "X";

    }

    @Test
    public void emptyBoardShouldReturnEmptyString() {
        String state = new Board("").next().state();
        assertThat(state).isEqualTo("");
    }
}
