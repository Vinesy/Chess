package model;

import java.util.Vector;

public class Bishop extends ChessPiece {

    Bishop(TEAM_e theTeam, ChessBoard theBoard) {
        super(theTeam, theBoard);
    }

    //The 4 directions a bishop can increment
    private final int[][] increments = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    @Override
    protected Vector<ChessPosition> getValidMoves(int row, int column) {
        Vector<ChessPosition> moves = new Vector<>();

        int diagonalRow = row;
        int diagonalColumn = column;

        //Iterate over the four directions
        for (int[] pos : increments) {
            //Continue in each direction until you hit something
            for (; ; ) {
                diagonalRow += pos[0];
                diagonalColumn += pos[1];

                //Make sure you didn't go off the board
                if (ChessPosition.isValidPosition(diagonalRow, diagonalColumn)) {
                    //if no piece is at the new position, add, and iterate
                    if (!board_.isPieceAt(diagonalRow, diagonalColumn)) {
                        moves.add(new ChessPosition(diagonalRow, diagonalColumn));
                        continue;
                    }// is the opposite teams piece is there.  Add and break.
                    else if (isOppositePieceAt(diagonalRow, diagonalColumn)) {
                        moves.add(new ChessPosition(diagonalRow, diagonalColumn));
                    }
                }
                break;
            }
        }

        return moves;

    }


}
