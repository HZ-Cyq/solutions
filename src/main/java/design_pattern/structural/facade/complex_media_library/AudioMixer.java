package design_pattern.structural.facade.complex_media_library;

import java.io.File;

/**
 * @author chenyuqun
 * @date 2020/11/19 5:00 下午
 */
public class AudioMixer {
    public File fix(VideoFile result) {
        System.out.println("AudioMixer: fixing audio...");
        return new File("temp");
    }
}
