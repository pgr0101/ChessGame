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
public class Rook extends Piece {

    public Rook(String ownerName, int color, Place location) {
        super(ownerName, color, location);
    }

    @Override
    protected ArrayList getPossibleMove() {
        ArrayList<Place> place = new ArrayList<Place>();
        int i = location.getRow();
        int j = location.getColumn();
        int k = 1;
        while ((i + k) != 8 && ChessGame.board.places[i + k][j].getPiece() == null) {
            place.add(ChessGame.board.places[i + k][j]);
            k++;
        }
        k = 1;
        while ((i - k) != -1 && ChessGame.board.places[i - k][j].getPiece() == null) {
            place.add(ChessGame.board.places[i - k][j]);
            k++;
        }
        k = 1;
        while ((j + k) != 8 && ChessGame.board.places[i][j + k].getPiece() == null) {
            place.add(ChessGame.board.places[i][j + k]);
            k++;
        }
        k = 1;
        while ((j - k) != -1 && ChessGame.board.places[i][j + k].getPiece() == null) {
            place.add(ChessGame.board.places[i][j - k]);
            k++;
        }
        if (place.size() == 0) {
            return null;
        } else {
            return place;
        }
    }

    @Override
    protected ArrayList getPossibleDelete() {
        ArrayList<Place> place = new ArrayList<Place>();
        int i = location.getRow();
        int j = location.getColumn();
        int k = 1;
        while ((i + k) != 8) {
            if (ChessGame.board.places[i + k][j].getPiece() != null) {
                place.add(ChessGame.board.places[i + k][j]);
                break;
            }
            k++;
        }
        k = 1;
        while ((i - k) != -1) {
            if (ChessGame.board.places[i - k][j].getPiece() != null) {
                place.add(ChessGame.board.places[i - k][j]);
                break;
            }
            k++;
        }
        k = 1;
        while ((j + k) != 8) {
            if (ChessGame.board.places[i][j + k].getPiece() != null) {
                place.add(ChessGame.board.places[i][j + k]);
                break;
            }
            k++;
        }
        k = 1;
        while ((j - k) != -1) {
            if (ChessGame.board.places[i][j - k].getPiece() != null) {
                place.add(ChessGame.board.places[i][j - k]);
                break;
            }
            k++;
        }
        if (place.size() == 0) {
            return null;
        } else {
            return place;
        }
    }

}
