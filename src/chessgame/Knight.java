
package chessgame;

import java.util.ArrayList;

/**
 *
 * @author pgr0101
 */
public class Knight extends Piece{
    public Knight(Player owner, int color, Place location, String ID , String name){
        super(owner, color, location , ID , name);
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
        // have to check color and check up and down and right and down in whiles to be ok
        // column up
        if((j+=2) <= 7){
            try{
                if(ChessGame.board.places[i + 1][j].getPiece() == null ){
                    answer.add(ChessGame.board.places[i + 1][j]);
                }
                
                if(ChessGame.board.places[i - 1][j].getPiece() == null ){
                    answer.add(ChessGame.board.places[i - 1][j]);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        // column down
        if((j-=2) >= 0){
            try{
                if(ChessGame.board.places[i + 1][j].getPiece() == null){
                    answer.add(ChessGame.board.places[i + 1][j]);
                }
                
                if(ChessGame.board.places[i - 1][j].getPiece() == null){
                    answer.add(ChessGame.board.places[i - 1][j]);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        // row right
        if((i+=2) <= 7){
            try{
                if(ChessGame.board.places[i][j + 1].getPiece() == null){
                    answer.add(ChessGame.board.places[i][j + 1]);
                }
                
                if(ChessGame.board.places[i][j - 1].getPiece() == null){
                    answer.add(ChessGame.board.places[i][j - 1]);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        // row left
        if((i-=2) >= 0){
            try{
                if(ChessGame.board.places[i][j + 1].getPiece() == null){
                    answer.add(ChessGame.board.places[i][j + 1]);
                }
                
                if(ChessGame.board.places[i][j - 1].getPiece() == null){
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
        // have to check color and check up and down and right and down in whiles to be ok
        // column up
        if((j+=2) <= 7){
            try{
                if(ChessGame.board.places[i + 1][j].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i + 1][j]);
                }
                
                if(ChessGame.board.places[i - 1][j].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i - 1][j]);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        // column down
        if((j-=2) >= 0){
            try{
                if(ChessGame.board.places[i + 1][j].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i + 1][j]);
                }
                
                if(ChessGame.board.places[i - 1][j].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i - 1][j]);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        // row right
        if((i+=2) <= 7){
            try{
                if(ChessGame.board.places[i][j + 1].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i][j + 1]);
                }
                
                if(ChessGame.board.places[i][j - 1].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i][j - 1]);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        // row left
        if((i-=2) >= 0){
            try{
                if(ChessGame.board.places[i][j + 1].getPiece().getColor() != this.color){
                    answer.add(ChessGame.board.places[i][j + 1]);
                }
                
                if(ChessGame.board.places[i][j - 1].getPiece().getColor() != this.color){
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
    
}
