package design_pattern.structural.facade.complex_media_library;

/**
 * @author chenyuqun
 * @date 2020/11/19 4:55 下午
 */
public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }
    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file");
        return buffer;
    }
}
