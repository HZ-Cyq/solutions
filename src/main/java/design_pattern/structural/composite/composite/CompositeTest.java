package design_pattern.structural.composite.composite;

import org.junit.Test;


/**
 * 组合模式让客户端可以统一单个对象(文件)和组合对象(目录)的处理逻辑。
 *
 * @author chenyuqun
 */
public class CompositeTest {
    /**
     * 文件结构
     * <p>
     * /a/
     * /a/aa.txt
     * /a/bb.txt
     * /a/movies/
     * /a/movies/c.avi
     * /b
     * /b/docs/
     * /b/docs/d.txt
     */
    String path = "/src/main/java/design_pattern/structural/composite/cyq";
    String aPath = path + "/a";
    String bPath = path + "/b";
    String a_aaPath = aPath + "/aa.txt";
    String a_bbPath = bPath + "/bb.txt";
    String a_moviesPath = a_aaPath + "/movies";
    String a_movies_cPath = a_moviesPath + "/c.avi";
    String b_docsPath = bPath + "/docs";
    String b_docs_dPath = b_docsPath + "/d.txt";

    @Test
    public void testComposite() {
        Directory fileSystemTree = new Directory(path);
        Directory node_a = new Directory(aPath);
        Directory node_b = new Directory(bPath);
        fileSystemTree.addSubNode(node_a);
        fileSystemTree.addSubNode(node_b);

        File node_a_aa = new File(a_aaPath);
        File node_a_bb = new File(a_bbPath);
        Directory node_a_movies = new Directory(a_moviesPath);
        node_a.addSubNode(node_a_aa);
        node_a.addSubNode(node_a_bb);
        node_a.addSubNode(node_a_movies);

        File a_movies_c = new File(a_movies_cPath);
        node_a_movies.addSubNode(a_movies_c);

        Directory b_docs = new Directory(b_docsPath);
        node_b.addSubNode(b_docs);

        File b_docs_d = new File(b_docs_dPath);
        b_docs.addSubNode(b_docs_d);

        System.out.println(path + " files num: " + fileSystemTree.countNumOfFiles());
        System.out.println(aPath + " files num: " + node_a.countNumOfFiles());
    }
}
