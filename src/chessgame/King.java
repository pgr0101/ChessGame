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
public class King extends Piece {

    public King(String ownerName, int color, Place location) {
        super(ownerName, color, location);
    }

    @Override
    protected ArrayList getPossibleMove() {
        ArrayList<Place> place = new ArrayList<Place>();
        int i = location.getRow();
        int j = location.getColumn();
        if (i + 1 != 8 && ChessGame.board.places[i + 1][j].getPiece() == null) {
            place.add(ChessGame.board.places[i + 1][j]);
        }
        if (j + 1 != 8 && ChessGame.board.places[i][j + 1].getPiece() == null) {
            place.add(ChessGame.board.places[i][j + 1]);
        }
        if ((i + 1 != 8 && j + 1 != 8) && ChessGame.board.places[i + 1][j + 1].getPiece() == null) {
            place.add(ChessGame.board.places[i + 1][j + 1]);
        }
        if (i - 1 != -1 && ChessGame.board.places[i - 1][j].getPiece() == null) {
            place.add(ChessGame.board.places[i - 1][j]);
        }
        if (j - 1 != -1 && ChessGame.board.places[i - 1][j].getPiece() == null) {
            place.add(ChessGame.board.places[i - 1][j]);
        }
        if ((i - 1 != -1 && j - 1 != -1) && ChessGame.board.places[i - 1][j - 1].getPiece() == null) {
            place.add(ChessGame.board.places[i - 1][j - 1]);
        }
        if ((i - 1 != -1 && j + 1 != 8) && ChessGame.board.places[i - 1][j + 1].getPiece() == null) {
            place.add(ChessGame.board.places[i - 1][j + 1]);
        }
        if ((i + 1 != 8 && j - 1 != -1) && ChessGame.board.places[i + 1][j - 1].getPiece() == null) {
            place.add(ChessGame.board.places[i + 1][j - 1]);
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
        if (i + 1 != 8 && ChessGame.board.places[i + 1][j].getPiece() != null && ChessGame.board.places[i + 1][j].getPiece().color != color) {
            place.add(ChessGame.board.places[i + 1][j]);
        }
        if (j + 1 != 8 && ChessGame.board.places[i][j + 1].getPiece() != null && ChessGame.board.places[i][j + 1].getPiece().color != color) {
            place.add(ChessGame.board.places[i][j + 1]);
        }
        if ((i + 1 != 8 && j + 1 != 8) && ChessGame.board.places[i + 1][j + 1].getPiece() != null && ChessGame.board.places[i + 1][j + 1].getPiece().color != color) {
            place.add(ChessGame.board.places[i + 1][j + 1]);
        }
        if (i - 1 != -1 && ChessGame.board.places[i - 1][j].getPiece() != null && ChessGame.board.places[i - 1][j].getPiece().color != color) {
            place.add(ChessGame.board.places[i - 1][j]);
        }
        if (j - 1 != -1 && ChessGame.board.places[i - 1][j].getPiece() != null && ChessGame.board.places[i - 1][j].getPiece().color != color) {
            place.add(ChessGame.board.places[i - 1][j]);
        }
        if ((i - 1 != -1 && j - 1 != -1) && ChessGame.board.places[i - 1][j - 1].getPiece() != null && ChessGame.board.places[i - 1][j - 1].getPiece().color != color) {
            place.add(ChessGame.board.places[i - 1][j - 1]);
        }
        if ((i - 1 != -1 && j + 1 != 8) && ChessGame.board.places[i - 1][j + 1].getPiece() != null && ChessGame.board.places[i - 1][j + 1].getPiece().color != color) {
            place.add(ChessGame.board.places[i - 1][j + 1]);
        }
        if ((i + 1 != 8 && j - 1 != -1) && ChessGame.board.places[i + 1][j - 1].getPiece() != null && ChessGame.board.places[i + 1][j - 1].getPiece().color != color) {
            place.add(ChessGame.board.places[i + 1][j - 1]);
        }
        if (place.size() == 0) {
            return null;
        } else {
            return place;
        }
    }

}
