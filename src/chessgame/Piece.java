/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.util.ArrayList;

/**
 *
 * @author G50
 */
public abstract class Piece {

    protected int color;//white=0 and black=1
    protected Place location;
    protected boolean status;
    private boolean deleteable = true;
    private String ID;
    private Player owner;
    private String name;

    /**
     * constructor
     *
     * @param owner
     * @param color
     * @param location
     * @param name
     */
    public Piece(Player owner, int color, Place location , String ID , String name) {
        this.owner = owner;
        this.color = color;
        this.location = location;
        status = true;
        this.ID = ID;
        this.name = name;
    }


    /**
     * this method return homes which this piece can be put on them as an
     * ArrayList this method is abstract and must be override in subclasses
     *
     * @return
     */
    protected abstract ArrayList getPossibleMove();

    /**
     * this method return homes which this piece can delete them as an ArrayList
     * this method is abstract and must be override in subclasses
     *
     * @return
     */
    protected abstract ArrayList getPossibleDelete();
    
    public int getColor(){
        return this.color;
    }
    
    
    
    public Place getLocation(){
        return this.location;
    }

    public void setLocation(Place location){
        this.location = location;
    }
    
    public void setStat(boolean stat){
        this.status = stat;
    }
    
    /**
     * king should not be deletable   
     */ 
    public boolean isDeletable(){
        return this.deleteable;
    }
    
    public void setDeletable(boolean deletable){
        this.deleteable = deletable;
    }
    /**
     * returns a string as id 01 to 016
     * first char is color and after that is the piece number
     */
    public String getID(){
        return this.ID;
    }
    
    public Player getPlayer(){
        return this.owner;
    }
    
    
    public String getKind(){
        return ""+this.getClass();
    }

    /**
     * it returns the kind of the piece for when we try to change it with a pawn
     */
    public String getName(){
        return this.name;
    }
}

    /*
      This method move each pieces according to type of piece if moving have
      done,return true and in otherwise return false
     
    protected boolean move(Place des) {
        ArrayList<Place> place = getPossibleMove();
        for (int i = 0; i < place.size(); i++) {
            if (des == place.get(i)) {
                ChessGame.board.storeMovement(new Movement(this, location, des));
                location.setPiece(null);
                location = des;
                des.setPiece(this);
                return true;
            }
        }
        return false;
    }
    */
    
    /*
     * This method delete other pieces which this piece can remove them from the
     * board if deleting have done,return true and in otherwise return false
     *
     * @param des
     * @return
     
    protected boolean deletePiece(Place des) {
        ArrayList<Place> place = getPossibleDelete();
        for (int i = 0; i < place.size(); i++) {
            if (des == place.get(i)) {
                ChessGame.board.storeMovement(new Movement(this, location, des, des.getPiece()));
                location.setPiece(null);
                location = des;
                des.getPiece().status = false;
                des.setPiece(this);
                return true;
            }
        }
        return false;
    }
    */