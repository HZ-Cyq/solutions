package generics.sgenerics.wildCard;

/**
 * @author playcrab_chenyuqun
 */
public class Fruit extends Food{
    public String color;

    public Fruit() {

    }

    public Fruit(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
