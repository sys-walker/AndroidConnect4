package com.eps.androidconnect4;

public class Board {
    private final int size;
    private final Cell[][] cells;

    public Board (int size){
        this.size = size;
        this.cells = new Cell[size][size];
    }
    //  getters and setters
    Position occupyCell (int column, Player player) {
        return null;
    }
    boolean hasValidMoves() {
        return false;
    }
    int firstEmptyRow(int column) {
        // Assume columnis playable. . .
        return -1;
    }
    int maxConnected(Position position) {
        // obtains the maximum number of connected positions in any direction

        return 0;
    }
}
