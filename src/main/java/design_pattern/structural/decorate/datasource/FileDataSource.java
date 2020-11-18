package design_pattern.structural.decorate.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author chenyuqun
 * @date 2020/11/17 3:39 下午
 */
public class FileDataSource implements DataSource {
    private String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(byte[] data) {
        File file = new File(name);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] readData() {
        File file = new File(name);
        int length = (int) file.length();
        byte[] re = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            re = new byte[length];
            fis.read(re,0, length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return re;
    }
}
