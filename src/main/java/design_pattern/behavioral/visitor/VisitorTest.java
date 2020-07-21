package design_pattern.behavioral.visitor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式：允许一个或者多个操作应用到一组对象上，解耦操作和对象本身
 *
 * @author chenyuqun
 */
public class VisitorTest {

    @Test
    public void testVisitor() {
        String resourceDirectory = "";
        Extractor extractor = new Extractor();
        List<ResourceFile> resourceFiles = listAllResourceFiles(resourceDirectory);
        for (ResourceFile resourceFile : resourceFiles) {
            // 如果是double dispatch的语言，下面这行就不会报错，就不需要访问者模式了。
            // extractor.visit(resourceFile);
            resourceFile.accept(extractor);
        }
        Compressor compressor = new Compressor();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(compressor);
        }
    }

    private static List listAllResourceFiles(String resourceDirectory) {
        List resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PptFile("c.ppt"));
        return resourceFiles;
    }
}
