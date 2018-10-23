package chessgame;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author pgr0101
 */
public class Board {

    Place[][] places = new Place[8][8]; // access is public for handling in other classes
    private Stack<Movement> movements = new Stack<Movement>();
    protected String ownerName_black, ownerName_white;

    public Board(String ownerName_black, String ownerName_white) {
        this.ownerName_black = ownerName_black;
        this.ownerName_white = ownerName_white;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                places[i][j] = new Place();
                places[i][j].setAddress(i + "" + j);
                places[i][j].setPiece(null);
            }
        }
        places[0][0].setPiece(new Rook(ownerName_white, 0, places[0][0]));
        places[0][1].setPiece(new Knight(ownerName_white, 0, places[0][1]));
        places[0][2].setPiece(new Bishop(ownerName_white, 0, places[0][2]));
        places[0][3].setPiece(new Queen(ownerName_white, 0, places[0][3]));
        places[0][4].setPiece(new King(ownerName_white, 0, places[0][4]));
        places[0][5].setPiece(new Bishop(ownerName_white, 0, places[0][5]));
        places[0][6].setPiece(new Knight(ownerName_white, 0, places[0][6]));
        places[0][7].setPiece(new Rook(ownerName_white, 0, places[0][7]));
        for (int i = 0; i < 8; i++) {
            places[1][i].setPiece(new Pawn(ownerName_white, 0, places[1][i]));
            places[6][i].setPiece(new Pawn(ownerName_black, 1, places[6][i]));
        }
        places[7][0].setPiece(new Rook(ownerName_black, 1, places[7][0]));
        places[7][1].setPiece(new Knight(ownerName_black, 1, places[7][1]));
        places[7][2].setPiece(new Bishop(ownerName_black, 1, places[7][2]));
        places[7][3].setPiece(new Queen(ownerName_black, 1, places[7][3]));
        places[7][4].setPiece(new King(ownerName_black, 1, places[7][4]));
        places[7][5].setPiece(new Bishop(ownerName_black, 1, places[7][5]));
        places[7][6].setPiece(new Knight(ownerName_black, 1, places[7][6]));
        places[7][7].setPiece(new Rook(ownerName_black, 1, places[7][7]));
    }

    /**
     * storing the movement for backing
     *
     * @param move
     */
    public void storeMovement(Movement move) {
        movements.add(move);
    }

    /**
     * for getting the last movement if we do many backs we call it as we need
     *
     * @return
     */
    public Movement getLastMovement() {
        Movement last = null;
        last = movements.pop();
        return last;
    }

    /**
     * we have to check the game situation after each movement
     *
     * @return
     */
    public boolean whoWins() {
        // check both kings situation here 
        return true;
        // return true or false
    }

    public void Back() {
        Movement m = movements.pop();
        m.unDo();
    }
}
