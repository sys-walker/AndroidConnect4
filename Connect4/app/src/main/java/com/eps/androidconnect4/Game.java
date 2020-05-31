package com.eps.androidconnect4;



public class Game {
    private final Board board;
    private final int toWin;

    private Status status;

    public Game(int rows, int columns, int toWin) {
        this.board = new Board(rows, columns);
        this.toWin = toWin;
        this.status = Status.PLAYER1_PLAYS;
    }

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
            position = board.play(column, player);
            if(board.maxConnected(position) == toWin){
                status = Status.PLAYER1_WINS;
            }else{
                status = Status.PLAYER2_PLAYS;
            }

        }else if(status == Status.PLAYER2_PLAYS){
            player = Player.player2();
            position = board.play(column, player);
            if(board.maxConnected(position) == toWin){
                status = Status.PLAYER2_WINS;
            }else{
                status = Status.PLAYER1_PLAYS;
            }
        }

        if(status != Status.PLAYER1_WINS && status != Status.PLAYER2_WINS && !board.hasValidMoves()){
            status = Status.DRAW;
        }

        return new Move(player, position);

    }


    public boolean isFinished() {
        return (status == Status.PLAYER1_WINS || status == Status.PLAYER2_WINS || status == Status.DRAW);
    }

}
