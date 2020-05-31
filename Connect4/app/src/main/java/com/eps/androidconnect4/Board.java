package com.eps.androidconnect4;

public class Board {
    private final int numRows;
    private final int numColumns;
    private final Player[][] cells;

    public Board(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.cells = new Player[numRows][numColumns];
    }

    public boolean canPlayColumn(int column) {
        if(column < numColumns && column >= 0 ){
            return cells[0][column] == null;
        }

        return false;

    }

    public boolean hasValidMoves() {

        for(int i=0; i<numColumns; i++){
            if(cells[0][i] == null){
                return true;
            }
        }

        return false;
    }

    public Position play(int column, Player player) {
        if(canPlayColumn(column)){
            for(int i = numRows-1; i>=0; i--){
                if(cells[i][column]==null){
                    cells[i][column]=player;
                    return new Position(i, column);
                }
            }
        }
        return null;

    }

    public int lastEmptyRow(int column) {
        if(canPlayColumn(column)){
            for(int i = numRows-1; i>=0; i--){
                if(cells[i][column]==null){
                    return i;
                }
            }


        }
        return -1;
    }



    public int maxConnected(Position position) {

        int numMaxConn=1;
        Player playCheck = cells[position.getRow()][position.getColumn()];

        for(int i=0; i<Direction.ALL.length; i++){
            numMaxConn = Math.max(numMaxConn, maxOnDirection(i, position, playCheck));
        }

        return numMaxConn;
    }

    private int maxOnDirection (int dir, Position position, Player playCheck){

        int auxMaxConn=1;
        Direction INVERT = Direction.ALL[dir].invert();

        switch(dir){

            case 0:
                if(position.getColumn()!=numColumns){
                    auxMaxConn += getConnections(position, playCheck, numColumns-position.getColumn()-1, Direction.ALL[dir]);
                }
                if(position.getColumn()!=0){
                    auxMaxConn += getConnections(position, playCheck, position.getColumn(), INVERT);
                }
                break;
            case 1:
                if(position.getRow()!=numRows){
                    auxMaxConn += getConnections(position, playCheck, numRows-position.getRow()-1, Direction.ALL[dir]);
                }

                if(position.getRow()!=0){
                    auxMaxConn += getConnections(position, playCheck, position.getRow(), INVERT);
                }
                break;
            case 2:
                if(position.getColumn()!=numColumns && position.getRow()!=numRows){
                    auxMaxConn += getConnections(position, playCheck, distanceToBounds(Direction.ALL[dir], position), Direction.ALL[dir]);
                }
                if(position.getColumn()!=0 && position.getRow()!=0){
                    auxMaxConn += getConnections(position, playCheck, distanceToBounds(INVERT, position), INVERT);
                }


                break;
            case 3:
                if(position.getColumn()!=0 && position.getRow()!=numRows){
                    auxMaxConn += getConnections(position, playCheck, distanceToBounds(Direction.ALL[dir], position), Direction.ALL[dir]);
                }
                if(position.getColumn()!=numColumns && position.getRow()!=0){
                    auxMaxConn += getConnections(position, playCheck, distanceToBounds(INVERT, position), INVERT);
                }
                break;

        }
        return auxMaxConn;
    }

    private int getConnections(Position position, Player playCheck, int condition, Direction direction){

        int auxMaxConn=0;
        Position auxPos = position;

        for(int i=0; i<=condition; i++){
            if(playCheck.isEqualTo(cells[auxPos.getRow()][auxPos.getColumn()])){
                if(!position.isEqualTo(auxPos)){
                    auxMaxConn++;
                }

                auxPos = auxPos.move(direction);

            }
        }

        return auxMaxConn;
    }

    private int distanceToBounds(Direction direction, Position position){

        Position auxPos = position;

        while((auxPos.getColumn()>= 0 && auxPos.getColumn() < numColumns) && (auxPos.getRow()>=0 && auxPos.getRow() < numRows) ){
            auxPos = auxPos.move(direction);
        }

        return Position.pathLength(auxPos, position) - 2;
    }

}
