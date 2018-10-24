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
    
    /**
     * @param black
     * @param white
     */
    public Board(Player black , Player white) {
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                places[i][j] = new Place();
                places[i][j].setAddress(i + "" + j);
                places[i][j].setPiece(null);
            }
        }
        places[0][0].setPiece(new Rook(white, 0, places[0][0] , "01" , "Rook"));
        white.addPiece(new Rook(white, 0, places[0][0] , "01" , "Rook"));
        places[0][1].setPiece(new Knight(white, 0, places[0][1], "02" , "Knight"));
        white.addPiece(new Knight(white, 0, places[0][1], "02" , "Knight"));
        places[0][2].setPiece(new Bishop(white, 0, places[0][2] , "03" , "Bishop"));
        white.addPiece(new Bishop(white, 0, places[0][2] , "03" , "Bishop"));
        places[0][3].setPiece(new Queen(white, 0, places[0][3] , "04" , "Queen"));
        white.addPiece(new Queen(white, 0, places[0][3] , "04" , "Queen"));
        places[0][4].setPiece(new King(white, 0, places[0][4] , "05" , "King"));
        white.addPiece(new King(white, 0, places[0][4] , "05" , "King"));
        places[0][5].setPiece(new Bishop(white, 0, places[0][5] , "06" , "Bishop"));
        white.addPiece(new Bishop(white, 0, places[0][5] , "06" , "Bishop"));
        places[0][6].setPiece(new Knight(white, 0, places[0][6] , "07" , "Kinght"));
        white.addPiece(new Knight(white, 0, places[0][6] , "07" , "Kinght"));
        places[0][7].setPiece(new Rook(white, 0, places[0][7] , "08" , "Rook"));
        white.addPiece(new Rook(white, 0, places[0][7] , "08" , "Rook"));
        for (int i = 9; i < 17; i++) {
            places[1][i].setPiece(new Pawn(white, 0, places[1][i] , "0"+i , "Pawn"));
            white.addPiece(new Pawn(white, 0, places[1][i] , "0"+i , "Pawn"));
            places[6][i].setPiece(new Pawn(black, 1, places[6][i] , "1"+i , "pawn"));
            black.addPiece(new Pawn(black, 1, places[6][i] , "1"+i , "pawn"));
        }
        places[7][0].setPiece(new Rook(black, 1, places[7][0], "11" , "Rook"));
        black.addPiece(new Rook(black, 1, places[7][0], "11" , "Rook"));
        places[7][1].setPiece(new Knight(black, 1, places[7][1], "12" , "Knight"));
        black.addPiece(new Knight(black, 1, places[7][1], "12" , "Knight"));
        places[7][2].setPiece(new Bishop(black, 1, places[7][2], "13", "Bishop"));
        black.addPiece(new Bishop(black, 1, places[7][2], "13", "Bishop"));
        places[7][3].setPiece(new Queen(black, 1, places[7][3], "14" , "Queen"));
        black.addPiece(new Queen(black, 1, places[7][3], "14" , "Queen"));
        places[7][4].setPiece(new King(black, 1, places[7][4], "15" , "King"));
        black.addPiece(new King(black, 1, places[7][4], "15" , "King"));
        places[7][5].setPiece(new Bishop(black, 1, places[7][5], "16" , "Bishop"));
        black.addPiece(new Bishop(black, 1, places[7][5], "16" , "Bishop"));
        places[7][6].setPiece(new Knight(black, 1, places[7][6], "17" , "Knight"));
        black.addPiece(new Knight(black, 1, places[7][6], "17" , "Knight"));
        places[7][7].setPiece(new Rook(black, 1, places[7][7], "18" , "Rook"));
        black.addPiece(new Rook(black, 1, places[7][7], "18" , "Rook"));
        this.black = black;
        this.white = white;
    }

    /**
     * we have to check the game situation after each movement
     * not implemented yet 
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
    public void Undo() {
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
            deleted.setLocation(null);
            home.setPiece(null);
            Movement m = new Movement(p, home, dest, deleted);
            movements.add(m);
            return true;
        } else if (dest.getPiece() == null && p.getPossibleMove().contains(dest)) {
            Place home = p.getLocation();
            p.setLocation(dest);
            dest.setPiece(p);
            home.setPiece(null);
            Movement m = new Movement(p, home, dest);
            movements.add(m);
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
     * it returns an array of places that the piece can move and delete the piece there
     * for when you wanna suggest the player in red background
     */
    public ArrayList getWhichCanDelete(Piece p){
        return p.getPossibleMove();
    }
    
    /**
     * it returns the pawn that should be changed if needed and we have to check it after each movement
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
    
    /***
     * it returns the pieces that we can use instead of the pawn that wanna be changed
     */
    public ArrayList toWhichPiece(Piece p){
        return p.getPlayer().deletedPieces();
    }
    
    /**
     * it changes new piece that player chose instead of the pawn
     */
    public void changePieceInsteadOfPawn(Piece newpiece , Piece pawn){
        pawn.setStat(false);
        newpiece.setStat(true);
        pawn.getLocation().setPiece(newpiece);
        newpiece.setLocation(pawn.getLocation());
        pawn.setLocation(null);
        pawn.getPlayer().addPiece(newpiece);
        pawn.getPlayer().addDeleted(pawn);
        
    }
}
