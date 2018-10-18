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

    protected String ownerName;
    protected int color;//white=0 and black=1
    protected Place location;
    protected boolean status;

    /**
     * constructor
     *
     * @param ownerName
     * @param color
     * @param location
     */
    public Piece(String ownerName, int color, Place location) {
        this.ownerName = ownerName;
        this.color = color;
        this.location = location;
        status = true;
    }

    /**
     * This method move each pieces according to type of piece if moving have
     * done,return true and in otherwise return false
     *
     * @param des
     * @return
     */
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

    /**
     * This method delete other pieces which this piece can remove them from the
     * board if deleting have done,return true and in otherwise return false
     *
     * @param des
     * @return
     */
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

}
