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

    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                places[i][j] = new Place();
                places[i][j].setAddress(i + "" + j);
            }
        }

        // mohammad reza bad az in ke mohre ha ro neveshti jaye avaliye mohreharo barashoon 
        // taeien kon in ja ham to khooneha taeien kon che mohrei hast
        // mitoni oonja be jaye string as class place estefade koni
    }

    /**
     * storing the movement for backing
     * @param move
     */
    public void storeMovement(Movement move) {
        movements.add(move);
    }

    /**
     * for getting the last movement if we do many backs we call it as we need
     * @return 
     */
    public Movement getLastMovement() {
        Movement last = null;
        last = movements.pop();
        return last;
    }

    /**
     * we have to check the game situation after each movement
     * @return 
     */
    public boolean whoWins() {
        // check both kings situation here 
        return true;
        // return true or false
    }

    
    public void Back(){
        Movement m = movements.pop();
        m.unDo();
    }
}
