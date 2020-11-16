package java_basic.io.io2.imp;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;

/**
 * @author chenyuqun
 * @date 2020/11/16 11:42 上午
 */
public class MyReader extends Reader {
    @Override
    public int read(@NotNull char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
