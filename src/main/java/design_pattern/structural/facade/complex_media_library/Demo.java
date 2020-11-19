package design_pattern.structural.facade.complex_media_library;

import java.io.File;

/**
 * 它在与复杂程序库和API协作时特别有用。
 * 通过使用简单接口，将绝大部分工作委派给其他类来识别。
 * 通常情况下，外观管理着其所用的对象的完整生命周期。
 *
 * @author chenyuqun
 * @date 2020/11/19 5:11 下午
 */
public class Demo {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        System.out.println(mp4Video);
    }
}
