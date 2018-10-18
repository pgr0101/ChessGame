package chessgame;

/**
 *
 * @author pgr0101
 */
public class Place {

    private String address;
    private Piece piece = null;

    /**
     * setting the address (like 00, 01 , ... , 77) as string
     *
     * @param address
     */
    public void setAddress(String address) {
        // if needed we can put some regexes on this and change the method return-type to boolean
        this.address = address;
    }

    /**
     * getting the address if needed the first char is the row and second one is
     * column
     *
     * @return
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * setting the piece that now exist in this place
     *
     * @param piece
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * getting the piece that exists in this place
     *
     * @return
     */
    public Piece getPiece() {
        if (piece == null) {
            return null;
        } else {
            return this.piece;
        }
    }

    public int getRow() {
        return Integer.parseInt(address.charAt(0) + "");
    }

    public int getColumn() {
        return Integer.parseInt(address.charAt(1) + "");
    }
}
