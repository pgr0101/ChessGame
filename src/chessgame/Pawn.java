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

// sarbaz
public class Pawn extends Piece {

    public Pawn(String ownerName, int color, Place location) {
        super(ownerName, color, location);
    }

    @Override
    protected ArrayList getPossibleMove() {
        int i = location.getRow();
        int j = location.getColumn();
        ArrayList<Place> place = new ArrayList<Place>();
        if (color == 0) {
            if (i != 7) {
                if (ChessGame.board.places[i + 1][j].getPiece() == null) {
                    place.add(ChessGame.board.places[i + 1][j]);
                }
                if (i == 1 && ChessGame.board.places[i + 1][j].getPiece() == null) {
                    if (ChessGame.board.places[i + 2][j].getPiece() == null) {
                        place.add(ChessGame.board.places[i + 2][j]);
                    }
                }
            } else {
                return null;
            }
        } else {
            if (i != 0) {
                if (ChessGame.board.places[i - 1][j].getPiece() == null) {
                    place.add(ChessGame.board.places[i - 1][j]);
                }
                if (i == 6 && ChessGame.board.places[i - 1][j].getPiece() == null) {
                    if (ChessGame.board.places[i - 2][j].getPiece() == null) {
                        place.add(ChessGame.board.places[i - 2][j]);
                    }
                }
            } else {
                return null;
            }
        }
        if (place.size() != 0) {
            return place;
        } else {
            return null;
        }
    }

    @Override
    protected ArrayList getPossibleDelete() {
        int i = location.getRow();
        int j = location.getColumn();
        ArrayList<Place> place = new ArrayList<Place>();
        if (color == 0) {
            switch (j) {
                case 7:
                    if (ChessGame.board.places[i + 1][j - 1].getPiece() != null && ChessGame.board.places[i + 1][j - 1].getPiece().color != 0) {
                        place.add(ChessGame.board.places[i + 1][j - 1]);
                    }
                    break;
                case 0:
                    if (ChessGame.board.places[i + 1][j + 1].getPiece() != null && ChessGame.board.places[i + 1][j + 1].getPiece().color != 0) {
                        place.add(ChessGame.board.places[i + 1][j + 1]);
                    }
                    break;
                default:
                    if (ChessGame.board.places[i + 1][j - 1].getPiece() != null && ChessGame.board.places[i + 1][j - 1].getPiece().color != 0) {
                        place.add(ChessGame.board.places[i + 1][j - 1]);
                    }
                    if (ChessGame.board.places[i + 1][j + 1].getPiece() != null && ChessGame.board.places[i + 1][j + 1].getPiece().color != 0) {
                        place.add(ChessGame.board.places[i + 1][j + 1]);
                    }
                    break;
            }
        } else {
            switch (j) {
                case 7:
                    if (ChessGame.board.places[i - 1][j - 1].getPiece() != null && ChessGame.board.places[i - 1][j - 1].getPiece().color != 1) {
                        place.add(ChessGame.board.places[i - 1][j - 1]);
                    }
                    break;
                case 0:
                    if (ChessGame.board.places[i - 1][j + 1].getPiece() != null && ChessGame.board.places[i - 1][j + 1].getPiece().color != 1) {
                        place.add(ChessGame.board.places[i - 1][j + 1]);
                    }
                    break;
                default:
                    if (ChessGame.board.places[i - 1][j - 1].getPiece() != null && ChessGame.board.places[i - 1][j - 1].getPiece().color != 1) {
                        place.add(ChessGame.board.places[i - 1][j - 1]);
                    }
                    if (ChessGame.board.places[i - 1][j + 1].getPiece() != null && ChessGame.board.places[i - 1][j + 1].getPiece().color != 1) {
                        place.add(ChessGame.board.places[i - 1][j + 1]);
                    }
                    break;
            }
        }
        if (place.size() != 0) {
            return place;
        } else {
            return null;
        }
    }
}
