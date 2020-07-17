package design_pattern.structural.flyweight.chess.flyweight;

import com.google.common.collect.Maps;

import javax.jnlp.SingleInstanceListener;
import java.util.Map;

/**
 * @author chenyuqun
 */
public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieces = Maps.newHashMap();

    public ChessBoard() {
        init();
    }
    private void init() {
        chessPieces.put(1,new ChessPiece(ChessPieceUnitFactory.getChessPiece(1),0,0));
        chessPieces.put(2,new ChessPiece(ChessPieceUnitFactory.getChessPiece(2),1,0));
    }
    private void move(int chessPieceId, int toPositionX, int toPositionY) {
        // ...省略...
    }
}
