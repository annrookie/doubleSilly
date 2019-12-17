import com.i2silly.common.util.NumberUtil;
import org.junit.Test;

public class NumberUtilTest {
    @Test
    public void numberFormatTest(){
        System.out.println(NumberUtil.numberFormat(12));
        System.out.println(NumberUtil.numberFormat(123.412,2));
    }
}
