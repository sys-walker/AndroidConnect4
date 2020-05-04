package com.eps.androidconnect4;

public class Player {
    private static final char PLAYER1 = '1';
    private static final char SYSTEM = '2';

    private final char id;

    private Player(char id) {
        this.id = id;
    }

    public static Player player1() {
        return new Player(PLAYER1);
    }

    public static Player player2() {
        return new Player(SYSTEM);
    }

    public boolean isEqualTo(Player other) {
        return (other != null) && this.id == other.id;
    }

    public boolean isPlayer1() {
        return this.id == PLAYER1;
    }

    public boolean isPlayer2() {
        return this.id == SYSTEM;
    }
}
