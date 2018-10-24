package chessgame;

/**
 *
 * @author pgr0101
 */
public class ChessGame {

    protected static Board board;

    /**
     * 
     * order is so important in naming
     * 
     * @param blackname 
     * @param whitename 
     */
    public ChessGame(String blackname , String whitename){
        Player black , white;
        black = new Player(blackname);
        white = new Player(whitename);
        board = new Board(black, white);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
