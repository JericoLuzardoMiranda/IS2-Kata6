package tests;

import software.ulpgc.kata6.Board;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTest {

    public static class Cases {
        public static final String board_1x1_all_dead_cells = ".";
        public static final String board_1x1_with_alive_cell = "X";

        public static final String board_2x2_all_alive_cells = "XX\nXX";
        public static final String board_2x2_all_dead_cells = "..\n..";
        public static final String board_2x2_with_on_alive_cell = "..\nX.";
        public static final String board_2x2_with_triangle_structure = "XX\n.X";

        public static final String board_3x3_with_all_alive_cells = "XXX\nXXX\nXXX";
        public static final String board_3x3_with_alive_cells_in_corners = "X.X\n...\nX.X";

        public static final String board_4x4_all_dead_cells = "....\n....\n....\n....";
        public static final String board_4x4_block_pattern = "....\n.XX.\n.XX.\n....";
        public static final String board_4x4_beehive_pattern = "....\n.XX.\nX..X\n.XX.\n....";
    }

    @Test
    public void emptyBoardShouldReturnEmptyString() {
        String state = new Board("").next().state();
        assertThat(state).isEqualTo("");
    }

    @Test
    public void board1x1AllDeadCellsShouldRemainSame() {
        String state = new Board(Cases.board_1x1_all_dead_cells).next().state();
        assertThat(state).isEqualTo(Cases.board_1x1_all_dead_cells);
    }

    @Test
    public void board1x1WithAliveCellShouldRemainDeadCell() {
        String state = new Board(Cases.board_1x1_all_dead_cells).next().state();
        assertThat(state).isEqualTo(Cases.board_1x1_all_dead_cells);
    }

    @Test
    public void board2x2WithAllAliveCellsShouldRemainSame() {
        String state = new Board(Cases.board_2x2_all_alive_cells).next().state();
        assertThat(state).isEqualTo(Cases.board_2x2_all_alive_cells);
    }

    @Test
    public void board2x2WithOneAliveCellShouldBecomeAllDead() {
        String state = new Board(Cases.board_2x2_with_on_alive_cell).next().state();
        assertThat(state).isEqualTo(Cases.board_2x2_all_dead_cells);
    }

    @Test
    public void board2x2WithTriangleStructureShouldBecomeAllAlive() {
        String state = new Board(Cases.board_2x2_with_triangle_structure).next().state();
        assertThat(state).isEqualTo(Cases.board_2x2_all_alive_cells);
    }

    @Test
    public void board3x3WithAllAliveCellsShouldHaveAliveCorners() {
        String state = new Board(Cases.board_3x3_with_all_alive_cells).next().state();
        assertThat(state).isEqualTo(Cases.board_3x3_with_alive_cells_in_corners);
    }

    @Test
    public void board4x4AllDeadCellsShouldRemainSame() {
        String state = new Board(Cases.board_4x4_all_dead_cells).next().state();
        assertThat(state).isEqualTo(Cases.board_4x4_all_dead_cells);
    }

    @Test
    public void board4x4WithBlockPatternShouldRemainSame() {
        String state = new Board(Cases.board_4x4_block_pattern).next().state();
        assertThat(state).isEqualTo(Cases.board_4x4_block_pattern);
    }

    @Test
    public void board4x4WithBeehivePatternShouldRemainSame() {
        String state = new Board(Cases.board_4x4_beehive_pattern).next().state();
        assertThat(state).isEqualTo(Cases.board_4x4_beehive_pattern);
    }

}
