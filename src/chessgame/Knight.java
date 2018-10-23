
package chessgame;

import java.util.ArrayList;

/**
 *
 * @author pgr0101
 */
public class Knight extends Piece{
    public Knight(String ownerName, int color, Place location){
        super(ownerName, color, location);
    }
    
    
    /**
     * it shows if possible to move can use for showing on the gui board of the game
     * if returned null shows that not possible to move 
     */
    @Override
    protected ArrayList getPossibleMove(){
        ArrayList<Place> answer = new ArrayList<Place>();
        int i = location.getRow();
        int j = location.getColumn();
        int k = 2;
        // have to check color and check up and down and right and down in whiles to be ok
        // column up
        while((j+k) <= 7){
            try{
                if(ChessGame.board.places[i + 1][j].getPiece() == null ||
                        ChessGame.board.places[i + 1][j].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i + 1][j]);
                }
                
                if(ChessGame.board.places[i - 1][j].getPiece() == null ||
                        ChessGame.board.places[i - 1][j].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i - 1][j]);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            k+=2;
        }
        k = 2;
        // column down
        while((j-=2) >= 0){
            try{
                if(ChessGame.board.places[i + 1][j].getPiece() == null ||
                        ChessGame.board.places[i + 1][j].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i + 1][j]);
                }
                
                if(ChessGame.board.places[i - 1][j].getPiece() == null ||
                        ChessGame.board.places[i - 1][j].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i - 1][j]);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        k = 2;
        // row right
        while((i+=2) <= 7){
            try{
                if(ChessGame.board.places[i][j + 1].getPiece() == null ||
                        ChessGame.board.places[i][j + 1].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i][j + 1]);
                }
                
                if(ChessGame.board.places[i][j - 1].getPiece() == null ||
                        ChessGame.board.places[i][j - 1].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i][j - 1]);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        k = 2;
        // row left
        while((i-=2) >= 0){
            try{
                if(ChessGame.board.places[i][j + 1].getPiece() == null ||
                        ChessGame.board.places[i][j + 1].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i][j + 1]);
                }
                
                if(ChessGame.board.places[i][j - 1].getPiece() == null ||
                        ChessGame.board.places[i][j - 1].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i][j - 1]);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(answer.size() == 0)
            return null;
        else 
            return answer;
    }

    // dont think so to be implementeed ?????
    @Override
    protected ArrayList getPossibleDelete() {
        ArrayList<Place> answer = new ArrayList<Place>();
        int i = location.getRow();
        int j = location.getColumn();
        
        
        if(answer.size() == 0)
            return null;
        else 
            return answer;
    
    }
    
}
