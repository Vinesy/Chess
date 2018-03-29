package model;

class ChessPosition {

    final int row_;
    final int column_;


    /**
     * This is an easy helper to verify board position.  This uses absolute Array position, 0 to 7
     *
     * @param row    the row
     * @param column the column
     * @throws IndexOutOfBoundsException if not a valid board position
     */
    ChessPosition(int row, int column) throws IndexOutOfBoundsException {
        if (!isValidRow(row) || !isValidColumn(column)) {
            throw new IndexOutOfBoundsException();
        } else {
            this.row_ = row;
            this.column_ = column;
        }
    }

    static private boolean isValidRow(int row) {
        return row >= 0 && row <= ChessBoard.ROWS - 1;
    }

    static boolean isValidColumn(int column) {
        return column >= 0 && column <= ChessBoard.COLUMNS - 1;
    }

    static boolean isValidPosition(int row, int column) {
        return (isValidRow(row) && isValidColumn(column));
    }

    /**
     * @return the Boards row position starting at 1
     */
    public int getViewedRow() {
        return row_ + 1;
    }

    /**
     * @return the boards column position in A to H form
     */
    public char getViewedColumn() {
        switch (column_) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            case 5:
                return 'F';
            case 6:
                return 'G';
            case 7:
                return 'H';
            default:
                return 'Z';
        }
    }


}
