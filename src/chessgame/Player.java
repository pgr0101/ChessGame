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
public class Player {

    private String name;
    private ArrayList<Piece> pieces;
    private ArrayList<Piece> deleted;

    public Player(String name) {
        this.name = name;
        pieces = new ArrayList<Piece>();
        deleted = new ArrayList<Piece>();
    }

    public void addPiece(Piece p) {
        p.setStat(true);
        if (deleted.contains(p)) {
            this.deleted.removeIf(dl -> dl.getID().equals(p.getID()));
        }
        this.pieces.add(p);

    }

    public void addDeleted(Piece deleted) {
        deleted.setStat(false);
        this.deleted.add(deleted);
        this.pieces.removeIf(dl -> dl.getID().equals(deleted.getID()));
    }

    public ArrayList<Piece> deletedPieces() {
        return this.deleted;
    }

    public String getName() {
        return this.name;
    }
}
