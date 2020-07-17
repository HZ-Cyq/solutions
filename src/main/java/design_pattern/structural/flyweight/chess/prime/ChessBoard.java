package design_pattern.structural.flyweight.chess.prime;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 棋盘
 * @author chenyuqun
 */
public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieces = Maps.newHashMap();
    public ChessBoard() {
        init();
    }
    private void init() {
        chessPieces.put(1, new ChessPiece(1,"车",ChessPiece.Color.BLACK, 0,0));
        chessPieces.put(2, new ChessPiece(2,"马", ChessPiece.Color.BLACK, 0 ,1));
        // ...省略摆放其他棋子的代码...
    }
    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        // ...省略...
    }
}
