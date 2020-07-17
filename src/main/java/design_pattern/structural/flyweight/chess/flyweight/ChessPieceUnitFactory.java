package design_pattern.structural.flyweight.chess.flyweight;

import com.google.common.collect.Maps;
import design_pattern.structural.flyweight.chess.prime.ChessPiece;

import java.util.Map;

/**
 * @author chenyuqun
 */
public class ChessPieceUnitFactory {
    private static final Map<Integer, ChessPieceUnit> pieces = Maps.newHashMap();

    static {
        pieces.put(1, new ChessPieceUnit(1, "车", ChessPieceUnit.Color.BLACK));
        pieces.put(2, new ChessPieceUnit(2, "马", ChessPieceUnit.Color.BLACK));
    }

    public static ChessPieceUnit getChessPiece(int chessPieceId) {
        return pieces.get(chessPieceId);
    }
}
