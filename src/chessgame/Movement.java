package chessgame;

/**
 *
 * @author pgr0101
 */
public class Movement {

    private Place home;
    private Place dest;
    private Piece movable;
    private Piece deleted;
    /**
     * movable : the piece that is moving
     * home : the first place
     * dest : destination of the piece
     * @param movable
     * @param home
     * @param dest
     */
    public Movement(Piece movable, Place home, Place dest) {
        // checking and throwing new exceptions if the place is empty        
        this.movable = movable;
        this.home = home;
        this.dest = dest;
    }
    /**
     * if we have a piece in the destination place 
     * and we have to delete it
     * @param movable
     * @param home
     * @param dest
     * @param deleted
     */
    public Movement(Piece movable, Place home, Place dest , Piece deleted) {
        this.movable = movable;
        this.home = home;
        this.dest = dest;
        this.deleted = deleted;
    }

    /**
     * get the piece that moved
     * @return 
     */
    public Piece getMovable() {
        return this.movable;
    }
    /**
     * get the first place
     * @return 
     */
    public Place getHome() {
        return this.home;
    }
    /**
     * get the destination
     * @return 
     */
    public Place getDest(){
        return this.dest;
    }
    
    /**
     * get the deleted piece if it exists\
     * if it returns null it means that nothing has been deleted
     * @return 
     */
    public Piece getDeleted(){
        return this.deleted;
    }
    
    public void unDo(){
        if(deleted != null){
            this.deleted.setStat(true);
            this.movable.setLocation(home);
            this.deleted.setLocation(dest);
            this.home.setPiece(this.movable);
            this.dest.setPiece(this.deleted);
        }else {
            this.movable.setLocation(home);
            this.home.setPiece(this.movable);
            this.dest.setPiece(null);
        }
    }
}
