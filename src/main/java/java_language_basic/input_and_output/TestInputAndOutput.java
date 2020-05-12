package java_language_basic.input_and_output;

import org.junit.Test;

import java.io.IOException;

/**
 * @author playcrab_chenyuqun
 */
public class TestInputAndOutput {

    public static void main(String[] args)  {
        try {
            char char1= (char)System.in.read();
            char char2 = (char)System.in.read();
            System.out.println("char1: " +char1 + ", char2:" + char2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
