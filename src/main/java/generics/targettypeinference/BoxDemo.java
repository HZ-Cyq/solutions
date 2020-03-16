package generics.targettypeinference;

import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class BoxDemo {

    public static <U> void addBox(U u, List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void addBox(U u) {
        Box<U> box = new Box<>();
        System.out.println("BoxDemo.addBox(U u)");
    }

    public static <U> void outputBoxes(List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

}
