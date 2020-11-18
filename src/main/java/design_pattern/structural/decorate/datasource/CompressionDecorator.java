package design_pattern.structural.decorate.datasource;


import java.util.Base64;

/**
 * @author chenyuqun
 * @date 2020/11/18 10:58 上午
 */
public class CompressionDecorator extends DataSourceDecorator{
    public CompressionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public byte[] readData() {
        // 读的时候，decode数据
        byte[] bytes = super.readData();
        return Base64.getDecoder().decode(bytes);
    }

    @Override
    public void writeData(byte[] data) {
        // 写的时候，encode数据
        byte[] bytes = Base64.getEncoder().encode(data);
        super.writeData(bytes);
    }
}
