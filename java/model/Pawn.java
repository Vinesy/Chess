package model;

import java.util.Vector;

public class Pawn extends ChessPiece {

    public Pawn(TEAM_e theTeam, ChessBoard theBoard) {
        super(theTeam, theBoard);
    }

    private final boolean isFirstMove_ = false;

    @Override
    protected Vector<ChessPosition> getValidMoves(int row, int column) {
        Vector<ChessPosition> moves = new Vector<>();

        //Increment one
        int advanceOneRow = row + (direction());
        if (!board_.isPieceAt(advanceOneRow, column)) {
            moves.add(new ChessPosition(advanceOneRow, column));
        }

        //Increment two on first move.
        if (!hasMadeFirstMove()) {
            int advanceTwoRows = row + (2 * direction());
            if (!board_.isPieceAt(advanceTwoRows, column)) {
                moves.add(new ChessPosition(advanceTwoRows, column));
            }
        }

        //Increment one Diagonal on capture
        int captureLeftColumn = column - 1;
        int captureRightColumn = column + 1;
        if (ChessPosition.isValidColumn(captureLeftColumn) &&
                isOppositePieceAt(advanceOneRow, captureLeftColumn)) {
            moves.add(new ChessPosition(advanceOneRow, captureLeftColumn));
        }

        if (ChessPosition.isValidColumn(captureRightColumn) &&
                isOppositePieceAt(advanceOneRow, captureRightColumn)) {
            moves.add(new ChessPosition(advanceOneRow, captureLeftColumn));
        }

        //Special En Passant Moves
        if (ChessPosition.isValidColumn(captureLeftColumn) &&
                isOppositePieceAt(row, captureLeftColumn)) {
            ChessPiece piece = board_.getPieceAt(row, captureLeftColumn);
            if (piece instanceof Pawn && ((Pawn) piece).isFirstMove_) {
                moves.add(new ChessPosition(advanceOneRow, captureLeftColumn));
                //TODO handle this capture in model
            }

        }

        if (ChessPosition.isValidColumn(captureRightColumn) &&
                isOppositePieceAt(row, captureRightColumn)) {
            ChessPiece piece = board_.getPieceAt(row, captureRightColumn);
            if (piece instanceof Pawn && ((Pawn) piece).isFirstMove_) {
                moves.add(new ChessPosition(advanceOneRow, captureRightColumn));
                //TODO handle this capture in model
            }
        }

        return moves;
    }


    private int direction() {
        if (isWhiteTeam()) {
            return 1;
        } else {
            return -1;
        }
    }

}
