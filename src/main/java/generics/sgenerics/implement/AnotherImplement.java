package generics.sgenerics.implement;

/**
 * @author playcrab_chenyuqun
 */
public class AnotherImplement implements GenericInterface<String>{
    String data;
    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }
}
