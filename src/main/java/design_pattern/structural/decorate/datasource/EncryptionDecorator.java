package design_pattern.structural.decorate.datasource;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @author chenyuqun
 * @date 2020/11/17 3:49 下午
 */
public class EncryptionDecorator extends DataSourceDecorator {
    private static Cipher enCipher;
    private static Cipher deCipher;
    private static Key key;

    // 初始化加解密工具
    static {
        String keyStr = "12345678";
        String encryptAlg = "DES";
        key = new javax.crypto.spec.SecretKeySpec(keyStr.getBytes(), encryptAlg);
        try {
            enCipher = Cipher.getInstance(encryptAlg);
            enCipher.init(Cipher.ENCRYPT_MODE, key);
            deCipher = Cipher.getInstance(encryptAlg);
            deCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

    }

    public EncryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public byte[] readData() {
        byte[] bytes = super.readData();
        try {
            // 读的时候，返回解密的数据
            return deCipher.doFinal(bytes);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeData(byte[] data) {
        byte[] bytes = null;
        try {
            // 写的时候，返回加密的数据
            bytes = enCipher.doFinal(data);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        super.writeData(bytes);
    }
}
