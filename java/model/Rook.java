package model;

import java.util.Vector;

public class Rook extends ChessPiece {


    Rook(TEAM_e theTeam, ChessBoard theBoard) {
        super(theTeam, theBoard);
    }

    //The 4 directions a rook can increment
    private final int[][] increments = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @Override
    protected Vector<ChessPosition> getValidMoves(int row, int column) {
        //TODO Code is the same for Rook, Bishop, Queen
        Vector<ChessPosition> moves = new Vector<>();

        int lateralRow = row;
        int lateralColumn = column;

        //Iterate over the four directions
        for (int[] pos : increments) {
            //Continue in each direction until you hit something
            for (; ; ) {
                lateralRow += pos[0];
                lateralColumn += pos[1];

                //Make sure you didn't go off the board
                if (ChessPosition.isValidPosition(lateralRow, lateralColumn)) {
                    //if no piece is at the new position, add, and iterate
                    if (!board_.isPieceAt(lateralRow, lateralColumn)) {
                        moves.add(new ChessPosition(lateralRow, lateralColumn));
                        continue;
                    }// is the opposite teams piece is there.  Add and break.
                    else if (isOppositePieceAt(lateralRow, lateralColumn)) {
                        moves.add(new ChessPosition(lateralRow, lateralColumn));
                    }
                }
                break;
            }
        }

        return moves;
    }
}
