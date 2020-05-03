package com.eps.androidconnect4;

public class Game {
    private final Board board;
    private final int toWin;
    private Status status;
    private boolean hasWinner;
    private Player turn;
    // state members related with time( . . .)
    public Game(int size, int toWin) {
        this.board= new Board(size);
        this.toWin =toWin;
    }

    //  getters and setters
    Position playOpponent () {
        return null;
    }
    void toggleTurn() {   }
    void manageTime() {    }
    boolean checkForFinish () {
    return false;
    }
    Object drop(int col){ /*Return type??*/
        return null;
    }
}
