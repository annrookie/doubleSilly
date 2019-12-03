import com.rookie.common.constant.Mode;
import com.rookie.common.constant.Month;
import com.rookie.common.util.StrUtil;
import org.junit.Test;

public class StrUtilTest {

    @Test
    public void isEmptyTest() {
        System.out.println(StrUtil.isEmpty(""));
        System.out.println(StrUtil.isEmpty(null));
        System.out.println(StrUtil.isNotEmpty("123"));
        System.out.println(StrUtil.isNotEmpty(" "));
    }

    @Test
    public void toNumStrTest() {
        System.out.println(StrUtil.toNumStr("adxaf"));
        System.out.println(StrUtil.isNumberStr("123415"));
    }

    @Test
    public void blankTest() {
        System.out.println(StrUtil.isBlank("d213 123"));
        System.out.println(StrUtil.isNotBlank("    "));
        System.out.println(StrUtil.hasBlank(" 12312 4124    "));
        System.out.println(StrUtil.hasBlank("12adxcqw"));
        System.out.println(StrUtil.blankCharToStr(" 1 3213   24 12   45", "。"));
        System.out.println(Month.Apr.ordinal());
    }

    @Test
    public void trimTest() {
        System.out.println(StrUtil.trim(" 123   1 ", Mode.TRIM_ALL));
    }

    @Test
    public void startWithTest() {
        System.out.println(StrUtil.startWith(null, '4'));
        System.out.println(StrUtil.startWith("abcasd", "aB"));
        System.out.println(StrUtil.startIgnoreCaseWith("abcasd", "aB"));
    }

    @Test
    public void endsWithTest() {
        System.out.println(StrUtil.endWith("adsva313asd", "xasd", false));
    }

    @Test
    public void upperFirstTest() {
        System.out.println(StrUtil.upperFirst(" null"));
        System.out.println(StrUtil.lowerFirst(" 1Null"));
    }
}
