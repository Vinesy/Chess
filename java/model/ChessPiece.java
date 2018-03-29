package model;


import java.util.Vector;

public abstract class ChessPiece {

    public enum TEAM_e {
        WHITE,
        BLACK
    }

    private final TEAM_e team_;
    private final boolean hasMadeFirstMove_;
    final ChessBoard board_;

    ChessPiece(TEAM_e theTeam, ChessBoard theBoard) {
        this.team_ = theTeam;
        this.board_ = theBoard;
        hasMadeFirstMove_ = false;
    }


    Vector<ChessPosition> getValidMoves(ChessPosition Position) {
        Vector<ChessPosition> moves = getValidMoves(Position.row_, Position.column_);
        if (moves.isEmpty()) {
            return null;
        } else {
            return moves;
        }
    }

    protected abstract Vector<ChessPosition> getValidMoves(int row, int column);

    final boolean hasMadeFirstMove() {
        return hasMadeFirstMove_;
    }

    final boolean isBlackTeam() {
        return (this.team_ == TEAM_e.BLACK);
    }

    final boolean isWhiteTeam() {
        return (this.team_ == TEAM_e.WHITE);
    }

    final boolean isOppositePieceAt(int row, int column) {
        if (isWhiteTeam()) {
            return board_.isWhitePieceAt(row, column);
        } else {
            return board_.isBlackPieceAt(row, column);
        }
    }

}

