package design_pattern.structural.decorate.datasource;

/**
 * @author chenyuqun
 * @date 2020/11/17 3:47 下午
 */
public class DataSourceDecorator implements DataSource {
    DataSource dataSource;

    public DataSourceDecorator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void writeData(byte[] data) {
        dataSource.writeData(data);
    }

    @Override
    public byte[] readData() {
        return dataSource.readData();
    }
}
