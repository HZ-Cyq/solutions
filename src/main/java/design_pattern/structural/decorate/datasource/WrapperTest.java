package design_pattern.structural.decorate.datasource;

import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * 测试编码String与加密str，为编写装饰器模式demo做准备
 *
 * @author chenyuqun
 * @date 2020/11/17 4:04 下午
 */
public class WrapperTest {

    /**
     * 测试Base64编码方法
     */
    @Test
    public void testBaseEncode() {
        String str = "hello base64!";
        String encodeStr = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println("encodeStr: " + encodeStr);
        byte[] decodeBytes = Base64.getDecoder().decode(encodeStr);
        String decodeStr = new String(decodeBytes);
        System.out.println("decodeStr: " + decodeStr);
    }

    /**
     * 测试加解密方法
     */
    @Test
    public void testEncryption() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        String str = "hello des!" ;
        String keyStr = "12345678";
        String encryptAlg = "DES";

        // 设置加密的Cipher
        Cipher enCipher;
        enCipher = Cipher.getInstance(encryptAlg);
        Key key = new javax.crypto.spec.SecretKeySpec(keyStr.getBytes(), encryptAlg);
        enCipher.init(Cipher.ENCRYPT_MODE, key);
        // 加密
        byte[] encodeBytes = enCipher.doFinal(str.getBytes());

        // 这里的encodeBytes1与encodeBytes不一样？要不然为什么下面解密的时候会出错？
        // 确实不一样。为什么不一样？
        String encodeStr = new String(encodeBytes);
        byte[] encodeBytes1 = encodeStr.getBytes();
        System.out.println(encodeBytes1);

        System.out.println("encodeBytes: " + encodeStr);

        // 设置解密的Cipher
        Cipher deCipher;
        deCipher = Cipher.getInstance(encryptAlg);
        deCipher.init(Cipher.DECRYPT_MODE, key);
        // 解密
        byte[] bytes2 = deCipher.doFinal(encodeStr.getBytes());
        System.out.println("decodeStr: " + new String(bytes2));
    }


    /**
     * 测试byte[]数组与String的转换
     */
    @Test
    public void testBytesAndString() {
        // 如果bytes有负数，转换就会有问题, 那要怎么解决呢？
        byte[] bytes = {-1,2,3,4,5,6,7,8,10,9};
        String str = new String(bytes, StandardCharsets.UTF_8);
        byte[] bytes1 = str.getBytes(Charset.defaultCharset());
        System.out.println(bytes1);
    }
}
