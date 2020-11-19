package design_pattern.structural.decorate.datasource;

/**
 * @author chenyuqun
 * @date 2020/11/18 11:07 上午
 */
public class Demo {
    public static void main(String[] args) {
        String filePath = "./src/main/java/design_pattern/structural/decorate/datasource/1.txt";
        DataSource dataSource = new FileDataSource(filePath);
        dataSource = new CompressionDecorator(dataSource);
        dataSource = new EncryptionDecorator(dataSource);
        // 原始数据先经过加密，再经过base64编码，存到文件中
        dataSource.writeData("hello world".getBytes());
        // 文件中的数据先经过base64解码，再解密，读出来。
        System.out.println(new String(dataSource.readData()));
    }
}
