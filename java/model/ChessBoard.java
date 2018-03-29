package model;


class ChessBoard {

    /* 8x8 cell
       8a  b  c  d  e  f  g  h
       7
       6
       5
       4
       3
       2
       1a  b  c  d  e  f  g  h

    */

    static final int ROWS = 8;
    static final int COLUMNS = 8;

    static private final ChessPiece.TEAM_e BLACK = ChessPiece.TEAM_e.BLACK;
    static private final ChessPiece.TEAM_e WHITE = ChessPiece.TEAM_e.WHITE;


    private final ChessPiece[][] board;

    ChessBoard() {

        board = new ChessPiece[][]{
                {new Rook(BLACK, this), new Knight(BLACK, this), new Bishop(BLACK, this), new Queen(BLACK, this), new King(BLACK, this), new Bishop(BLACK, this), new Knight(BLACK, this), new Rook(BLACK, this)},
                {new Pawn(BLACK, this), new Pawn(BLACK, this), new Pawn(BLACK, this), new Pawn(BLACK, this), new Pawn(BLACK, this), new Pawn(BLACK, this), new Pawn(BLACK, this), new Pawn(BLACK, this)},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {new Pawn(WHITE, this), new Pawn(WHITE, this), new Pawn(WHITE, this), new Pawn(WHITE, this), new Pawn(WHITE, this), new Pawn(WHITE, this), new Pawn(WHITE, this), new Pawn(WHITE, this)},
                {new Rook(WHITE, this), new Knight(WHITE, this), new Bishop(WHITE, this), new Queen(WHITE, this), new King(WHITE, this), new Bishop(WHITE, this), new Knight(WHITE, this), new Rook(WHITE, this)}
        };
    }

    ChessPiece getPieceAt(ChessPosition position) {
        return getPieceAt(position.row_, position.column_);
    }

    ChessPiece getPieceAt(int row, int column) {
        return board[row][column];
    }

    boolean isPieceAt(int row, int column) {
        return (board[row][column] != null);
    }

    boolean isBlackPieceAt(int row, int column) {
        if (isPieceAt(row, column)) {
            return getPieceAt(row, column).isBlackTeam();
        } else {
            return false;
        }
    }

    boolean isWhitePieceAt(int row, int column) {
        if (isPieceAt(row, column)) {
            return getPieceAt(row, column).isWhiteTeam();
        } else {
            return false;
        }
    }


}