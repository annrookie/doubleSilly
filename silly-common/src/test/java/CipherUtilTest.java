import com.i2silly.common.constant.CipherEnum;
import com.i2silly.common.util.CipherUtil;
import org.junit.Test;

/**
 * <h3>DoubleSilly</h3>
 * <P>加解密工具类测试</p>
 *
 * @author i2silly
 * @date 2020/01/09
 */
public class CipherUtilTest {
    @Test
    public void base64Test() {
        String str = "哈哈哈";
        String s = CipherUtil.base64Encrypt(str);
        System.out.println(s);
        System.out.println(CipherUtil.base64Decrypt(s));
    }

    @Test
    public void md5Test() {
        System.out.println(CipherUtil.md5Encrypt("123456"));
//        System.out.println(CipherUtil.hmacMd5Encrypt("123456","null"));
    }

    @Test
    public void encryptTest(){
        System.out.println(CipherUtil.encrypt("123456", CipherEnum.MD5));
        System.out.println(CipherUtil.encrypt("123456", CipherEnum.SHA224));
        System.out.println(CipherUtil.encrypt("123456", CipherEnum.SHA256));
        System.out.println(CipherUtil.encrypt("123456", CipherEnum.SHA384));
        System.out.println(CipherUtil.encrypt("123456", CipherEnum.SHA512));
    }

    @Test
    public void hmacEncryptTest(){
        System.out.println(CipherUtil.hmacEncrypt("123456", "1", CipherEnum.HMACMD5));
        System.out.println(CipherUtil.hmacEncrypt("123456", "1", CipherEnum.HMACSHA1));
        System.out.println(CipherUtil.hmacEncrypt("123456", "1", CipherEnum.HMACSHA224));
        System.out.println(CipherUtil.hmacEncrypt("123456", "1", CipherEnum.HMACSHA256));
        System.out.println(CipherUtil.hmacEncrypt("123456", "1", CipherEnum.HMACSHA384));
        System.out.println(CipherUtil.hmacEncrypt("123456", "1", CipherEnum.HMACSHA512));
    }

    @Test
    public void urlEncode(){
        System.out.println(CipherUtil.urlEncode("你好"));
        System.out.println(CipherUtil.urlDecode("%E4%BD%A0%E5%A5%BD"));
    }


}
