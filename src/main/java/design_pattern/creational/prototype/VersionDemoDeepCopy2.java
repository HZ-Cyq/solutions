package design_pattern.creational.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author chenyuqun
 */
public class VersionDemoDeepCopy2 {

    // Deep copy 序列化之后再反序列化。
    public static Object deepCopy(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(object);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);

        return oi.readObject();
    }

    public static void main(String[] args) {
        SearchWord searchWord = new SearchWord("a", 1, 1);
        SearchWord copyWord = null;
        try {
            copyWord = (SearchWord) deepCopy(searchWord);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        searchWord.setKeyWord("b");
        System.out.println("searchWord: " + searchWord);
        System.out.println("copyWord: " + copyWord);
    }
}
