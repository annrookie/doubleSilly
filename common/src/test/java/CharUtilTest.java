import com.rookie.common.util.CharUtil;
import org.junit.Test;

public class CharUtilTest {

    @Test
    public void isUpLetter() {
        System.out.println(CharUtil.isUpLetter('a'));
        System.out.println(CharUtil.isUpLetter('Z'));
    }

    @Test
    public void toStringTest() {
        System.out.println(CharUtil.toString('a'));
        System.out.println('a');
    }
}
