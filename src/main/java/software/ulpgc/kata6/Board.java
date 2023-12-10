package software.ulpgc.kata6;

import java.util.List;

import static java.lang.String.join;
import static java.lang.String.valueOf;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;

public class Board {
    private final static char aliveCell = 'X';
    private final static char deadCell = '.';
    private final static String lineBreak = "\n";
    private final String[] state;

    public Board(String[] state) {
        this.state = state;
    }

    public Board(String state) {
        this(state.split(lineBreak));
    }

    public Board next() {
        return new Board(calculate());
    }

    private String calculate() {
        return range(0, rows())
                .mapToObj(i -> calculateRow(i) + "\n")
                .collect(joining());
    }

    private String calculateRow(int i) {
        return range(0, cols())
                .mapToObj(j -> format(calculateCell(i,j)))
                .collect(joining());
    }

    private char calculateCell(int i, int j) {
        return shouldBeAlive(i,j) ? aliveCell : deadCell;
    }

    private boolean shouldBeAlive(int i, int j) {
        return isAlive(i,j) ?
                is(countAliveNeighbors(i,j), 2, 3) :
                is(countAliveNeighbors(i,j), 3);
    }

    private int countAliveNeighbors(int i, int j) {
        return (int) neighborsOf(i,j).stream()
                .filter(CheckAlive::check)
                .count();
    }

    public String state() {
        return join(lineBreak, state);
    }

    private interface CheckAlive {
        boolean check();
    }

    private List<CheckAlive> neighborsOf(int i, int j) {
        return List.of(
                () -> isAlive(i-1, j-1),
                () -> isAlive(i-1, j),
                () -> isAlive(i-1, j+1),
                () -> isAlive(i, j-1),
                () -> isAlive(i, j+1),
                () -> isAlive(i+1, j-1),
                () -> isAlive(i+1, j),
                () -> isAlive(i+1, j+1)
        );

    }

    private boolean is(int value, int... options) {
        return stream(options).anyMatch(o->o == value);
    }

    private boolean isAlive(int i, int j) {
        return isInBounds(i,j) && cellAt(i,j) == aliveCell;
    }

    private char cellAt(int i, int j) {
        return state[i].charAt(j);
    }

    private boolean isInBounds(int i, int j) {
        return i >= 0 && i < rows() && j >= 0 && j < cols();
    }

    private String format(char state) {
        return valueOf(state);
    }

    private int cols() {
        return state[0].length();
    }

    private int rows() {
        return state.length;
    }

}
