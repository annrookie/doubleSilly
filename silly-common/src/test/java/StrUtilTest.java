import com.i2silly.common.constant.ModeEnum;
import com.i2silly.common.constant.MonthEnum;
import com.i2silly.common.util.StrUtil;
import org.junit.Test;

import java.util.Arrays;

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
        System.out.println(MonthEnum.Apr.ordinal());
    }

    @Test
    public void trimTest() {
        System.out.println(StrUtil.trim(" 123   1 ", ModeEnum.TRIM_ALL));
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

    @Test
    public void addTest() {
        System.out.println(StrUtil.addPrefix("", "", true));
        System.out.println(StrUtil.addPrefix("", ""));
        System.out.println(StrUtil.addSuffix("123", "1"));
        System.out.println(StrUtil.addSuffix("12312", "12", true));
        System.out.println(StrUtil.addPrefixAndSuffix("", "", "", false));
        System.out.println(StrUtil.addPrefixAndSuffix("asd", "231", "412"));
    }

    @Test
    public void randomTest() {
        System.out.println(StrUtil.getUuid());
        System.out.println(StrUtil.uuid());
    }

    @Test
    public void caseChangeTest() {
        System.out.println(StrUtil.caseChange("AdsxVasd"));
    }

    @Test
    public void concatTest() {
        System.out.println(StrUtil.concat("123", "123", "das"));
    }

    @Test
    public void replaceTest() {
        System.out.println(StrUtil.replace("null", -1, 0, '*'));
        System.out.println(StrUtil.replace("abca4124142124dqe", 1, 12, "111"));
        System.out.println(StrUtil.hide("asd4214124124124fasv12d", '`', 3, 6));
        System.out.println(StrUtil.hide("35123412445"));
    }

    @Test
    public void reverseTest() {
        System.out.println(StrUtil.reverse("abddrq"));
    }

    @Test
    public void avgDivideTest() {
        System.out.println(Arrays.toString(StrUtil.avgDivide("abcd", 0)));
    }

    @Test
    public void underlineToHumpTest(){
        System.out.println(StrUtil.underlineToHump("abc_dfDasdwead_fast"));
        System.out.println(StrUtil.humpToUnderline(""));
        System.out.println(StrUtil.humpToUnderline(null));
        System.out.println(StrUtil.humpToUnderline("adsakjx123,142"));
        System.out.println(StrUtil.humpToUnderline(">:@#!@"));
        System.out.println(StrUtil.humpToUnderline("HelloWorld"));
        System.out.println(StrUtil.humpToUnderline("HelloWoDSA"));
    }
}
