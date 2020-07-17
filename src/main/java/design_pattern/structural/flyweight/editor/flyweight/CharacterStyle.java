package design_pattern.structural.flyweight.editor.flyweight;

import java.awt.*;

/**
 * @author chenyuqun
 */
public class CharacterStyle {
    private Font font;
    private int size;
    private int colorRGB;

    public CharacterStyle(Font font, int size, int colorRGB) {
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }

    @Override
    public boolean equals(Object o) {
        CharacterStyle otherStyle = (CharacterStyle) o;
        return this.font.equals(otherStyle.font) && this.size == otherStyle.size && this.colorRGB == otherStyle.colorRGB;
    }
}
