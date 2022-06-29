package JSONObject;

import com.google.common.collect.Lists;
import io.vavr.Tuple2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author chenyuqun
 * @date 2022/3/14 8:44 下午
 */
public class DownloadFiles {
    /**
     * @param filePath 文件将要保存的目录
     * @param method   请求方法，包括POST和GET
     * @param url      请求的路径
     * @return
     * @从制定URL下载文件并保存到指定目录
     */

    public static File saveUrlAs(String url, String filePath, String fileName, String method) {
        //System.out.println("fileName---->"+filePath);
        //创建不同的文件夹目录
        File file = new File(filePath);
        //判断文件夹是否存在
        if (!file.exists()) {
            //如果文件夹不存在，则创建新的的文件夹
            file.mkdirs();
        }
        FileOutputStream fileOut = null;
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            // 建立链接
            URL httpUrl = new URL(url);
            conn = (HttpURLConnection) httpUrl.openConnection();
            //以Post方式提交表单，默认get方式
            conn.setRequestMethod(method);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // post方式不能使用缓存
            conn.setUseCaches(false);
            //连接指定的资源
            conn.connect();
            //获取网络输入流
            inputStream = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //判断文件的保存路径后面是否以/结尾
            if (!filePath.endsWith("/")) {
                filePath += "/";
            }
            //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
            fileOut = new FileOutputStream(filePath + fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fileOut);

            byte[] buf = new byte[10240];
            int length = bis.read(buf);
            //保存文件
            while (length != -1) {
                bos.write(buf, 0, length);
                length = bis.read(buf);
            }
            bos.close();
            bis.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("抛出异常！！");
        }
        return file;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String url = "http://www.bjnzdata.com/download/01.%e6%96%b0%e7%ba%a6%e9%83%a8%e5%88%86%ef%bc%88%e5%ae%8c%e6%95%b4%ef%bc%89/";
        Tuple2<List<String>, List<String>> allDirectoryPath = findAllDirectoryPath(url);
        for (int j = 0; j < allDirectoryPath._1.size(); j++) {
//            String photoUrl = "http://www.bjnzdata.com/download/01.新约部分（完整）/04.约翰福音/";   //文件URL地址
//            String filePath = "01.新约部分/04.约翰福音/";      //保存目录
            String photoUrl = allDirectoryPath._1.get(j);
            String filePath = allDirectoryPath._2.get(j);
            Tuple2<List<String>, List<String>> allUrls = findAllUrls(photoUrl);
            System.out.println(allUrls);
            System.out.println(allUrls._1.size());
            int length = allUrls._1.size();
            for (int i = 0; i < length; i++) {
                System.out.println("开始下载：" + allUrls._2.get(i));
                File file = saveUrlAs(allUrls._1.get(i), "01.新约部分/" + filePath, allUrls._2.get(i), "GET");
                System.out.println("下载完成：" + file.getName() + "path: " + file.getCanonicalPath());
            }
        }
    }

    public static Tuple2<List<String>, List<String>> findAllDirectoryPath(String url) throws IOException {
        List<String> urls = Lists.newArrayList();
        List<String> names = Lists.newArrayList();
        Document document = Jsoup.connect(url).get();
        Elements as = document.select("a");
        for (Element a : as) {
            String href = a.attributes().get("href");
            if ("/download/".equals(href) || href.length() - 1 != (href.lastIndexOf("/")) || href.startsWith("04") || href.startsWith("06")) {
                continue;
            }
            urls.add(a.baseUri() + href);
            names.add(URLDecoder.decode(href, "utf-8"));
        }
        System.out.println(urls);
        System.out.println(names);
        return new Tuple2<>(urls, names);
    }

    /**
     * 找到所有的 mp3 文件信息
     *
     * @param url
     * @return 1是url, 2是文件名
     */
    public static Tuple2<List<String>, List<String>> findAllUrls(String url) throws IOException {
        List<String> urls = Lists.newArrayList();
        Document document = Jsoup.connect(url).get();
        Elements as = document.select("a");
        for (Element a : as) {
            String s = a.attributes().toString();
            String[] split = s.split("\\.");
            if (split.length != 0 && "MP3\"".equals(split[split.length - 1]) || "mp3\"".equals(split[split.length - 1])) {
                int start = s.indexOf("\"");
                int end = s.lastIndexOf("\"");
                String substring = s.substring(start + 1, end);
                String childrenUrl = a.baseUri() + substring;
                childrenUrl = childrenUrl.replaceAll("&amp;", "&");
                urls.add(childrenUrl);
            }
        }
        List<String> fileNames = Lists.newArrayList();
        for (String mp3Url : urls) {
            System.out.println(mp3Url);
            int lastIndexOf = mp3Url.lastIndexOf("/");
            String fileName = mp3Url.substring(lastIndexOf + 1);
            fileName = URLDecoder.decode(fileName, "utf-8");
            fileName = fileName.replaceAll("&amp;", "&");
            fileNames.add(fileName);
        }
        System.out.println(fileNames);
        return new Tuple2<>(urls, fileNames);
    }

}
