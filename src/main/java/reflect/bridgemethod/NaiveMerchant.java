package reflect.bridgemethod;


import java.lang.reflect.Method;
/**
 * java的桥接方法：
 * https://blog.csdn.net/jiaobuchong/article/details/83722193
 * @author playcrab_chenyuqun
 */
public class NaiveMerchant extends Merchant {
    @Override
    public Double actionPrice(double price) {
        return 0.9 * price;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Merchant merchant = new NaiveMerchant();
        Number price = merchant.actionPrice(40);
        System.out.println(price);
        Method method = NaiveMerchant.class.getMethod("actionPrice", double.class);
        System.out.println("isBridge: " + method.isBridge());
    }
}
