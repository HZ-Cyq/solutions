package onjava8.f14_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenyuqun
 * @date 2021/6/17 11:07 上午
 */
public class FileToWordsRegexp {
    private String all;

    public FileToWordsRegexp(String filePath) throws IOException {
        all = Files.lines(Paths.get(filePath)).skip(1).collect(Collectors.joining(" "));
        System.out.println(all);
    }

    public Stream<String> stream() {
        return Pattern.compile("[ .,?]+").splitAsStream(all);
    }

    public static void main(String[] args) throws IOException {
        FileToWordsRegexp fw = new FileToWordsRegexp("./test.txt");
        fw.stream().forEach(System.out::println);
        fw.stream().forEach(System.out::println);
    }
}
