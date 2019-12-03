import com.rookie.common.util.ArrayUtil;
import com.rookie.common.util.RandomUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class RandomUtilTest {

    @Test
    public void randomTest() {
        System.out.println(RandomUtil.random());
        System.out.println(RandomUtil.random("",10));
        System.out.println(RandomUtil.randomLetter());
        System.out.println(RandomUtil.randomLetter(2));
        System.out.println(RandomUtil.randomUpLetter());
        System.out.println(RandomUtil.randomLowLetter());
        System.out.println(RandomUtil.randomNum());
        System.out.println(RandomUtil.randomList(5));
    }

    @Test
    public void warpTest(){
        int[] i = {1,23};
        Integer[] i2 = {1,32};
        int i1 = 1;
        System.out.println(i.getClass().getCanonicalName());
        System.out.println(i2.getClass().getCanonicalName());
        System.out.println(ArrayUtil.isArray(null));
    }
}
