package books.onjava8.f19_type_info;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenyuqun
 * @date 2021/5/19 5:00 下午
 */
public class RegexTest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d{3,4})-(\\d{7,8})");
        Matcher m = p.matcher("010-12345677");
        if(m.matches()) {
            String whole = m.group(0);
            String area = m.group(1);
            String tel = m.group(2);
            System.out.println(whole);
            System.out.println(area);
            System.out.println(tel);
        }
    }
}
