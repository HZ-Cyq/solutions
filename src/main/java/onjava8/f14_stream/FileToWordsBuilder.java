package onjava8.f14_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author chenyuqun
 * @date 2021/6/16 2:20 下午
 */
public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws IOException {
        // Files.lines(Paths.get(filePath))的返回值是Stream<String>
        Files.lines(Paths.get(filePath)).skip(1).forEach(line -> {
            for (String s : line.split("[ .?,]+")) {
                builder.add(s);
            }
        });
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws IOException {
        String s = "./test.txt";
        FileToWordsBuilder fileToWordsBuilder = new FileToWordsBuilder(s);
        Stream<String> stream = fileToWordsBuilder.stream();
        stream.skip(1).forEach(System.out::println);
    }
}
