package JSONObject;

/**
 * @author chenyuqun
 * @date 2022/3/14 9:00 下午
 */

import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

public class Urll {

    // 定义的全局变量
    public static Vector<String> svecOutUrl = new Vector<String>();
    public static Vector<String> svecBadUrl = new Vector<String>();
    public static Vector<String> svecAUrl = new Vector<String>();
    public static final int DEEP = 3; // 遍历的深度
    public static boolean bl; // 判断标志
    private static String loc;
    private static Parser parser; // 对超文本进行分析

    private static String hostName = "sina.com";

    // 由于网站中URL之间的连接构成了图，所以对图的遍历这里采用深度优先的方法。
    public static void extractLinks(String loc) throws Exception {

        String str1;
        URL wwwurl;
        boolean byes;

        Vector<String> vecUrl = new Vector<String>();

        // 解析 <a>
        try {
            parser = new Parser(loc); // 原理见HTMLParser
            bl = true;
        } catch (Exception e) {
            bl = false;
            e.printStackTrace();
        }

        String filterStr = "a";
        TagNameFilter filter = new TagNameFilter(filterStr);
        NodeList links = parser.extractAllNodesThatMatch(filter);
        for (int i = 0; i < links.size(); i++) {
            if (bl) {
                byes = true;
                LinkTag LinkTag = (LinkTag) links.elementAt(i);
                str1 = LinkTag.getLink();
                System.out.println("" + i);
                System.out.println(str1);
                if (str1.equals(""))
                    continue;
                if (!svecAUrl.contains(str1)) {
                    try {
                        // 　判断是否可连接
                        wwwurl = new URL(str1);
                        URLConnection con = wwwurl.openConnection();
                        con.setConnectTimeout(1000);
                        con.getInputStream();
                    } catch (SocketTimeoutException e) {
                        byes = false;
                        svecBadUrl.add(str1);
                        continue;
                    } catch (Exception e) {
                        byes = false;
                        continue;
                    }
                    if (GetHostName(str1).equals(hostName)) {
                        svecAUrl.add(str1);
                        vecUrl.add(str1);
                    } else {
                        svecOutUrl.add(str1);
                    }
                }
            }
        }

        // 递归调用
        String strNew;
        int b = 1;
        if (b <= DEEP) {

            for (int i = 0; i < vecUrl.size(); i++) {
                strNew = (String) vecUrl.get(i);
                extractLinks(strNew);
            }
        }

    }

    // 通过该函数来判断所得URL是否是本网站的URL
    public static String GetHostName(String host) {
        URL aurl;
        String ss = " ";
        try {
            aurl = new URL(host);
            ss = aurl.getHost();
            ss = ss.substring(ss.length() - 10, ss.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ss;
    }

}
