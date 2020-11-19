package design_pattern.structural.facade.complex_media_library;

/**
 * @author chenyuqun
 * @date 2020/11/19 2:56 下午
 */
public class CodecFactory {
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if(type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        } else {
            System.out.println("CodeFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}
