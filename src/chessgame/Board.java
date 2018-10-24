package chessgame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author pgr0101
 */
public class Board {

    Place[][] places = new Place[8][8]; // access is public for handling in other classes
    private Stack<Movement> movements = new Stack<Movement>();
    protected Player white , black;
    

    // i have to change the board completely
    
    public Board(Player black , Player white) {
        this.black = black;
        this.white = white;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                places[i][j] = new Place();
                places[i][j].setAddress(i + "" + j);
                places[i][j].setPiece(null);
            }
        }
        places[0][0].setPiece(new Rook(white, 0, places[0][0] , "01" , "Rook"));
        places[0][1].setPiece(new Knight(white, 0, places[0][1], "02" , "Knight"));
        places[0][2].setPiece(new Bishop(white, 0, places[0][2] , "03" , "Bishop"));
        places[0][3].setPiece(new Queen(white, 0, places[0][3] , "04" , "Queen"));
        places[0][4].setPiece(new King(white, 0, places[0][4] , "05" , "King"));
        places[0][5].setPiece(new Bishop(white, 0, places[0][5] , "06" , "Bishop"));
        places[0][6].setPiece(new Knight(white, 0, places[0][6] , "07" , "Kinght"));
        places[0][7].setPiece(new Rook(white, 0, places[0][7] , "08" , "Rook"));
        for (int i = 9; i < 17; i++) {
            places[1][i].setPiece(new Pawn(white, 0, places[1][i] , "0"+i , "Pawn"));
            places[6][i].setPiece(new Pawn(black, 1, places[6][i] , "1"+i , "pawn"));
        }
        places[7][0].setPiece(new Rook(black, 1, places[7][0], "11" , "Rook"));
        places[7][1].setPiece(new Knight(black, 1, places[7][1], "12" , "Knight"));
        places[7][2].setPiece(new Bishop(black, 1, places[7][2], "13", "Bishop"));
        places[7][3].setPiece(new Queen(black, 1, places[7][3], "14" , "Queen"));
        places[7][4].setPiece(new King(black, 1, places[7][4], "15" , "King"));
        places[7][5].setPiece(new Bishop(black, 1, places[7][5], "16" , "Bishop"));
        places[7][6].setPiece(new Knight(black, 1, places[7][6], "17" , "Knight"));
        places[7][7].setPiece(new Rook(black, 1, places[7][7], "18" , "Rook"));
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
     * we have to check the game situation after each movement
     *
     * @return
     */
    public boolean win() {
        // check both kings situation here 
        return true;
        // return true or false
    }

    /**
     * if we wanna make a back action in the game
     */
    public void Back() {
        Movement m = movements.pop();
        m.unDo();
    }

    /**
     * it just moves the piece or move and delete the piece in the destination
     */
    public boolean move(Piece p, Place dest) {
        if (dest.getPiece().getColor() != p.getColor() && p.getPossibleDelete().contains(dest)) {
            // delete
            Piece deleted = dest.getPiece();
            Place home = p.getLocation();
            dest.setPiece(p);
            p.setLocation(dest);
            deleted.setStat(false);
            Movement m = new Movement(p, home, dest, deleted);
            movements.add(m);
            return true;
        } else if (dest.getPiece() == null && p.getPossibleMove().contains(dest)) {
            Place home = p.getLocation();
            p.setLocation(dest);
            dest.setPiece(p);
            Movement m = new Movement(p, home, dest);
            return true;
        }

        return false;
    }
    
    /**
     * it returns an array that contains the places that the piece can move to theme  
     * for when you wanna suggest the player in green background
     */
    public ArrayList getPieceWherecanGo(Piece p){
        return p.getPossibleMove();
    }
    
    
    /**
     * it returns an array of places that it can move and delete the piece there
     * for when you wanna suggest the player in red background
     */
    public ArrayList getWhichCanDelete(Piece p){
        return p.getPossibleMove();
    }
    
    /**
     * it changes pawn when it achieves the last place in the board it should be as a suggestion
     */
    public Piece wannaChangePawn(){
        
        for(int i = 0 ; i < 8 ; i++){
            if(places[0][i].getPiece() instanceof Pawn && places[0][i].getPiece().getColor() == 0){
                return places[0][i].getPiece();
            }
        }
        
        for(int i = 0 ; i < 8 ; i++){
            if(places[7][i].getPiece() instanceof Pawn && places[7][i].getPiece().getColor() == 1){
                return places[7][i].getPiece();
            }
        }
        
        return null;
    }
    
    
}
