package design_pattern.structural.flyweight.editor.flyweight;

import com.google.common.collect.Lists;

import java.awt.*;
import java.util.List;

/**
 * @author chenyuqun
 */
public class CharacterStyleFactory {
    private List<CharacterStyle> styles = Lists.newArrayList();
    public CharacterStyle getCharacterStyle(Font font, int size, int colorRGB) {
        CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
        for(CharacterStyle style : styles) {
            if(style.equals(newStyle)) {
                return style;
            }
        }
        styles.add(newStyle);
        return newStyle;
    }
}
