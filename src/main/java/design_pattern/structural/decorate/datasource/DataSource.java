package design_pattern.structural.decorate.datasource;

/**
 * @author chenyuqun
 * @date 2020/11/17 3:38 下午
 */
public interface DataSource {
    void writeData(byte[] data);

    byte[] readData();
}
