package model;

import java.util.Vector;

class Model {


    private ChessBoard board;

    public Model() {

        this.board = new ChessBoard();

    }


    public void resetBoard() {
        this.board = new ChessBoard();
    }

    public Vector<ChessPosition> getMovesAt(ChessPosition position) {

        ChessPiece piece = this.board.getPieceAt(position);

        if (piece == null) {
            return null;
        } else {
            return piece.getValidMoves(position);
        }


    }


}
