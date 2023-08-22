package books.on_java_8_base.B18_string;

public class Immutable {
    public static void main(String[] args) {
//        String mango = "mango";
//        String s = "abc" + mango + "def" + 47;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("1321").append(231).append("dsa");
        System.out.println(append);
        System.out.println(stringBuilder);
    }
}
