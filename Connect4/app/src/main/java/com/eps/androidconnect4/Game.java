package com.eps.androidconnect4;

public class Game {
    private final Board board;
    private final int toWin;
    private Status status;
    private boolean hasWinner;
    private Player turn;
    // state members related with time( . . .)
    public Game(int size, int toWin) {
        this.board = new Board(size);
        this.toWin = toWin;
        this.status = Status.PLAYER1_PLAYS;
    }

    //  getters and setters
    public Status getStatus() {
        return status;
    }
    public boolean canPlayColumn(int column) {
        return (board.canPlayColumn(column));
    }

    public Move play(int column) {

        Player player = Player.player1();
        Position position = null;
        if(status == Status.PLAYER1_PLAYS){
            player = Player.player1();
            position = board.occupyCell(column, player);


            if(board.maxConnected(position) == toWin){
                status = Status.PLAYER1_WINS;
            }else{
                status = Status.SYSTEM_PLAYS;
            }

        }else if(status == Status.SYSTEM_PLAYS){
            player = Player.player2();
            position = board.occupyCell(column, player);
            if(board.maxConnected(position) == toWin){
                status = Status.SYSTEM_PLAYS;
            }else{
                status = Status.PLAYER1_PLAYS;
            }
        }

        if(status != Status.PLAYER1_WINS && status != Status.SYSTEM_PLAYS && !board.hasValidMoves()){
            status = Status.DRAW;
        }

        return new Move(player, position);

    }




    Position playOpponent () {
        return null;
    }




    void toggleTurn() {   }
    void manageTime() {    }
    boolean checkForFinish () {
        return (status == Status.PLAYER1_WINS || status == Status.SYSTEM_WINS  || status == Status.DRAW);
    }
    Object drop(int col){ /*Return type??*/
        return null;
    }


}
