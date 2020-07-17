package design_pattern.structural.flyweight.editor.prime;

import com.google.common.collect.Lists;

import javax.print.DocFlavor;
import java.awt.*;
import java.util.List;

/**
 * @author chenyuqun
 */
public class Editor {
    private List<Character> chars = Lists.newArrayList();

    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        Character character = new Character(c, font, size, colorRGB);
        chars.add(character);
    }
}
