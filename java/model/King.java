package model;

import java.util.Vector;

public class King extends ChessPiece {

    King(TEAM_e theTeam, ChessBoard theBoard) {
        super(theTeam, theBoard);
    }

    @Override
    protected Vector<ChessPosition> getValidMoves(int row, int column) {
        return null;
    }
}