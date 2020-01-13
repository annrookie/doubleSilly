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
        String str = "123456";
        String s = CipherUtil.base64Encrypt(str);
        System.out.println(s);
        System.out.println(CipherUtil.base64Decrypt(s));
    }

    @Test
    public void md5Test() {
        System.out.println(CipherUtil.md5Encrypt("123456{1}"));
    }
}
