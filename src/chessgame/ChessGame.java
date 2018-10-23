package chessgame;

/**
 *
 * @author pgr0101
 */
public class ChessGame {

    protected static Board board;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ownerName_black = null, ownerName_white = null;
        board = new Board(ownerName_black, ownerName_white);
    }

}
