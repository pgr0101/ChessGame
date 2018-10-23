/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.util.ArrayList;

/**
 *
 * @author Irana
 */
public class King extends Piece{

    public King(String ownerName, int color, Place location) {
        super(ownerName, color, location);
    }

    @Override
    protected ArrayList getPossibleMove() {
        ArrayList<Place> place=new ArrayList<Place>();
        int i= location.getRow();
        int j=location.getColumn();
        
        
        
        
        if(place.size()==0){
            return null;
        }else{
            return place;
        }
    }

    @Override
    protected ArrayList getPossibleDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
